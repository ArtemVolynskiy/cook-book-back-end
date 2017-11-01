package web.controllers.adminController;


import com.fasterxml.jackson.databind.node.TextNode;
import javassist.NotFoundException;
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

@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = AdminRestController.JSON_UTF8)
public class AdminRestController {
    static final String REST_URL = "/admin";
    static final String JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8_VALUE;

    private static final Logger LOG = LoggerFactory.getLogger(AdminRestController.class);

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


    @GetMapping(value = "/findByEmail")
    public ResponseEntity<User> getByEmail(@RequestParam("email") String email) {
        LOG.debug("Searching user by email: email = {}", email);
        try {
            User user = userService.getByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } catch (NotFoundException e) {
            return null;
        }
    }

    @GetMapping(value = "/findId")
    public ResponseEntity<User> getById(@RequestParam("id") int id) {
        try {
            User user = userService.get(id);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } catch (NotFoundException e) {
            return null;
        }
    }

    @PostMapping(value = "/update}")
    public void updateUser(@RequestBody User user) {
        LOG.debug("Update user, received parameter: user = {}", user);
        userService.update(user);
    }

    @DeleteMapping (value = "/delete")
    public HttpStatus deleteIngredient (@RequestBody TextNode id) {
        LOG.debug("Delete ingredient, received parameter: id = {}", id);
        try {
            userService.delete(Integer.parseInt(id.textValue()));
            return HttpStatus.OK;
        } catch (NotFoundException| IllegalArgumentException e) {
            return HttpStatus.NOT_FOUND;
        }
    }

    public @GetMapping(value= "/all")
    List<User> getAllUsers() {
        LOG.debug("Get all");
        return userService.getAll();
    }
}