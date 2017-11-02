package web.controllers.adminController;


import com.fasterxml.jackson.databind.node.TextNode;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

/**
 * <p>This class is responsible for manipulation of users registered in the database. It contains methods to find, update and delete existing users.</p>
 */

@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = AdminRestController.JSON_UTF8)
public class AdminRestController {
    static final String REST_URL = "/admin";
    static final String JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8_VALUE;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminRestController.class);

    private final
    UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetings() {
        return "Welcome to administrative panel!";
    }

    /**
     * <p>Method is responsible for retrieving users from userService provided by Spring
     * through autowired annotation</p>
     *
     * <p>Search is based on the email of the user. In case if requested user is not registered in the database HttpStatus 'Not Found' will be returned.</p>
     * @param email the email of the user about to be retrieved. Case insensitive.
     * @return existing user entity
     */
    @GetMapping(value = "/findByEmail")
    public ResponseEntity<User> getByEmail(@RequestParam("email") String email) {
        LOGGER.debug("Searching user by email: {}", email);

        User user = userService.getByEmail(email);
        if (user == null) {
            LOGGER.error("User with email: {} not found", email);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * <p>Method is responsible for retrieving users from userService provided by Spring
     * through autowired annotation</p>
     *
     * <p>Search is based on the id of the user. In case if requested user is not registered in the database HttpStatus 'Not Found' will be returned.</p>
     * @param id the identification number of the user about to be retrieved. Case insensitive.
     * @return existing user entity
     */
    @GetMapping(value = "/findId")
    public ResponseEntity<User> getById(@RequestParam("id") int id) {
        LOGGER.debug("Searching user by id: {}", id);

        User user = userService.get(id);
        if (user == null) {
            LOGGER.error("User with id: {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    /**
     * <p>Method is responsible for updating existing user. If provided user is not registered in the database HttpStatus 'Not Found' will be returned</p>
     * @param user the user about to be updated
     * @return ResponseEntity with updated user and relevant HttpStatus
     */
    @PostMapping(value = "/update}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        LOGGER.debug("Update user, received parameter: user = {}", user);

        User u = userService.get(user.getId());
        if (u == null) {
            LOGGER.error("Update failed, user with name: {} not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    /**
     * <p>Method is responsible for deleting existing user. If provided user is not registered in the database HttpStatus 'Not Found' will be returned</p>
     * @param id the id of the user about to be deleted
     * @return ResponseEntity with relevant HttpStatus
     */
    @DeleteMapping (value = "/delete")
    public HttpStatus deleteIngredient (@RequestBody TextNode id) {
        LOGGER.debug("Delete ingredient, received parameter: id = {}", id);

        User u = userService.get(Integer.parseInt(id.textValue()));
        if (u == null) {
            LOGGER.error("Delete failed, user with id: {} not found", id);
            return HttpStatus.NOT_FOUND;
        }
        userService.delete(u.getId());
        return HttpStatus.OK;
    }

    /**
     * <p>Method is responsible for fetching all existing user. If the result list will be empty HttpStatus 'Not Found' will be returned</p>
     * @return ResponseEntity with relevant HttpStatus and List of all user registered in the database
     */
    @GetMapping(value= "/all")
    public ResponseEntity<List<User>>getAllUsers() {
        LOGGER.debug("Get all");
        List<User> users = userService.getAll();
        if (users == null || users.size() == 0) {
            LOGGER.error("Fetching all users failed, result list is empty");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}