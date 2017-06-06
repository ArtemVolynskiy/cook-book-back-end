package web.restControllers;


import com.fasterxml.jackson.databind.node.TextNode;
import javassist.NotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(AdminRestController.REST_URL)
public class AdminRestController {
    static final String REST_URL = "/admin";

    private final
    UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String greetings() {
        return "Welcome to administrative panel!";
    }


    @GetMapping(value = "/findmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getByEmail(@RequestParam("email") String email) {
        try {
            User user = userService.getByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } catch (NotFoundException e) {
            return null;
        }
    }

    @GetMapping(value = "/findid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getById(@RequestParam("id") int id) {
        try {
            User user = userService.get(id);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } catch (NotFoundException e) {
            return null;
        }
    }

    @PostMapping(value = "/update}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping (value = "/delete")
    HttpStatus deleteIngredient (@RequestBody TextNode textNode) {
        try {
            userService.delete(Integer.parseInt(textNode.textValue()));
            return HttpStatus.OK;
        } catch (NotFoundException| IllegalArgumentException e) {
            return HttpStatus.NOT_FOUND;
        }
    }

    @GetMapping(value= "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<User> getAllUsers() {
        return userService.getAll();
    }
}