package web.controllers.userController;

import javassist.NotFoundException;
import model.Recipe;
import model.User;
import model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;
import service.UserService;
import web.AuthorizedUser;

import javax.persistence.NoResultException;
import java.util.Set;


@RestController
@RequestMapping(value = UserRestController.REST_URL)
public class UserRestController {
    static final String REST_URL = "/user";

    private final
    UserService userService;

    private final
    RecipeService recipeService;

    @Autowired
    public UserRestController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String greetings() {
        return "Welcome to user panel!";
    }

    @PutMapping(value = "/register" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping (value = "/buildration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findRecipe(@RequestParam int calories) {
        return new ResponseEntity<>(recipeService.buildRation(calories), HttpStatus.OK);
    }

    @GetMapping (value = "/findrecipe", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> findRecipe (@RequestParam("name") String name) {
        try {
            return new ResponseEntity<>(recipeService.findByName(name), HttpStatus.OK);
        } catch ( NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value = "/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Recipe>> getRecipes(){
       Set<Recipe> userRecipes = userService.findById(AuthorizedUser.id()).getUserRecipes();
        return new ResponseEntity<>(userRecipes, HttpStatus.OK);
    }

    @PutMapping(value = "/countRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus countRate(@RequestBody UserInfo userInfo) {

            userService.countCalories(userInfo);
            return HttpStatus.OK;
    }

    @PutMapping (value = "/saverecipe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> saveRecipe(@RequestBody Recipe recipe ) {
        try {
            return new ResponseEntity<>(userService.saveRecipe(AuthorizedUser.id(), recipe), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
