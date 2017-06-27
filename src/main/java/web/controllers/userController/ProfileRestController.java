package web.controllers.userController;

import javassist.NotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;


@RestController
@CrossOrigin()
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController {
    static final String REST_URL = "/profile";

    private final UserService userService;

    @Autowired
    public ProfileRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> get() {
        try {
            return new ResponseEntity<>(userService.get(AuthorizedUser.id()), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping (value = "/delete")
    HttpStatus delete() {
        try {
            this.userService.delete(AuthorizedUser.id());
            return HttpStatus.OK;
        } catch (NotFoundException e) {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
