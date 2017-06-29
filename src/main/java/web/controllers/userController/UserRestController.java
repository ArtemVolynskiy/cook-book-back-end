package web.controllers.userController;

import model.Recipe;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;
import service.UserService;

import javax.persistence.NoResultException;
import java.util.List;


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

    @PutMapping(value = "/create" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping (value = "/buildration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Recipe>> findRecipe(@RequestBody User user) {
        return new ResponseEntity<>(recipeService.getAll(), HttpStatus.FOUND); // TODO : build daily ration constructing algorithm
    }

    @GetMapping (value = "/findrecipe", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> findRecipe (@RequestParam("name") String name) {
        try {
            return new ResponseEntity<>(recipeService.findByName(name), HttpStatus.FOUND);
        } catch ( NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping (value = "/saverecipe", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> saveRecipe(@RequestBody Recipe recipe ) {
        try {
            return new ResponseEntity<>(userService.saveRecipe(AuthorizedUser.id(), recipe), HttpStatus.FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}