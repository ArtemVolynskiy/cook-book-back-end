package web.controllers.userController;

import model.Recipe;
import model.User;
import model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;
import service.UserService;
import util.error.CustomError;
import web.AuthorizedUser;
import web.controllers.AbstractRecipeController;

import java.util.Set;

/**
 * Class is responsible for all the data manipulations made by the end user. Can only be accessed if the user is authorized.
 */


@RestController
@RequestMapping(value = UserRestController.REST_URL)
public class UserRestController extends AbstractRecipeController {
    static final String REST_URL = "/user";

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    private final
    UserService userService;


    @Autowired
    public UserRestController(UserService userService, RecipeService recipeService) {
        super(recipeService);
        this.userService = userService;
    }

    /**
     * Registration of the new user in the database.
     * @param user Initial data from the user. First input data is rather poor, since the rest information about the user should be provided letter on.
     * @return new User instance with unique id number.
     */
    @PutMapping(value = "/register")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        LOGGER.info("Registering new user, email: {}", user.getEmail());

        User u = userService.save(user);
        if (u != null) {
            LOGGER.error("Error creating user with email: {}, user already exists", user.getEmail());
            return new ResponseEntity<>(new CustomError("User with email: " + user.getEmail()) + " already exists", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    /**
     * Method creating set of recipes that fit to user's daily calories limit.
     * @param calories Number of calories user consumes in a day.
     * @return set of three recipes with additional snacks and drinks where needed.
     */
    @GetMapping (value = "/buildration")
    public ResponseEntity findRecipe(@RequestParam int calories) {
        return super.buildRation(calories);
    }

    /**
     * Saves recipe for a user if. Does not create new recipe in the database. Simply creates Many to Many relationships between the user and the recipe.
     * @param recipe Recipe choosen by the user
     * @return User instance with all recipes saved for the user.
     */
    @PutMapping (value = "/saverecipe")
    ResponseEntity<User> saveRecipe(@RequestBody Recipe recipe ) {
        LOGGER.info("Saving recipe {} for a user id: ", recipe.getName(), AuthorizedUser.id());
        return new ResponseEntity<>(userService.saveRecipe(AuthorizedUser.id(), recipe), HttpStatus.OK);
    }

    /**
     * Searches for the recipe.
     * @param name Name of requested recipe.
     * @return instance of requested recipe.
     */
    @GetMapping (value = "/findrecipe")
    public ResponseEntity<?> findRecipeIngredients(@RequestParam("name") String name) {
        return super.findRecipeIngredients(name);
    }

    /**
     *
     * @return Method returns recipes that vere saved for the authorized user.
     */
    @GetMapping (value = "/recipes")
    public ResponseEntity<?> getUserRecipes(){
        LOGGER.info("Fetching recipes for a user: {}", AuthorizedUser.id());

        Set<Recipe> userRecipes = userService.findById(AuthorizedUser.id()).getUserRecipes();
        if (userRecipes == null) {
            LOGGER.error("Error fetching recipes for a user: ", AuthorizedUser.id());
            return new ResponseEntity<>(new CustomError("Error fetching recipes for a user " + AuthorizedUser.id()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userRecipes, HttpStatus.OK);
    }

    /**
     * Method is responsible for counting the number of calories user should consume in a day to meet his weight expectations (keep, loose, gain).
     * @param userInfo Info provided by the user (age, sex, weight, etc...)
     * @return Http status based on the result of requested operation
     */
    @PutMapping(value = "/countrate")
    public HttpStatus countRate(@RequestBody UserInfo userInfo) {
        LOGGER.info("Counting calories rate");

        User user = userService.countCalories(userInfo);
        if (user == null) {
            LOGGER.error("Error counting calories rate");
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
