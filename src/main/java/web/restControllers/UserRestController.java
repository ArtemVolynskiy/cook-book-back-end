package web.restControllers;


import javassist.NotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String getName(String name) {
        System.out.println("Hello World");
        return "Hello World!";
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
    @ResponseBody
    User saveUser(@PathVariable("id") int id){
       return userService.save(id);
    }

    @RequestMapping(value = "/find/{email}", method = RequestMethod.POST)
    User getByEmail(@PathVariable("email") String email) {
        try {
            return userService.getByEmail(email);
        } catch (NotFoundException e) {
            return null;
        }
    }

    @RequestMapping(value = "/")
}
