package web.controllers.userController;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import web.AuthorizedUser;


@RestController
@CrossOrigin()
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController {
    static final String REST_URL = "/profile";
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileRestController.class);

    private final UserService userService;

    @Autowired
    public ProfileRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method is designed to return information to user about his current profile. It's only available if user is logged in.
     * @return profile of authorized user
     */
    @GetMapping
    public ResponseEntity<User> get() {
        LOGGER.info("Getting user's profile");
        return new ResponseEntity<>(userService.get(AuthorizedUser.id()), HttpStatus.OK);
    }

    /**
     * This method deletes user's profile from the database. It's only available if user is logged in.
     * @return HttpStatus
     */
    @DeleteMapping (value = "/delete")
    HttpStatus delete() {
        LOGGER.info("Deleting user's profile");
        this.userService.delete(AuthorizedUser.id());
        return HttpStatus.OK;

    }
}
