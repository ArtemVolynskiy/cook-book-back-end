package web.restControllers;


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
    String getName(String name) {
        User user1 = new User(1,"Maxim", "max@gmail.com", "123123", 2000, true, true);
        userService.save(user1);
        return "Welcome to administrative panel!";
    }

    @PostMapping(value = "/create" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User>  createUser(@RequestBody User user) {
        User createdUser = userService.save(user);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getByEmail(@RequestParam("email") String email) {
        try {
            User user = userService.getByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } catch (NotFoundException e) {
            return null;
        }
    }

    @PutMapping(value = "/update}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    void deleteUser(@PathVariable int id) {
        try {
            System.out.println("Hi");
            userService.delete(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value= "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<User> getAllUsers() {
        return userService.getAll();
    }
}