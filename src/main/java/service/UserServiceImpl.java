package service;


import javassist.NotFoundException;
import model.Recipe;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import org.springframework.util.Assert;
import web.controllers.userController.AuthorizedUser;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    public User save(User user) {
        User u = userRepository.save(user);
        u.setPassword("");
        return u;
    }

    public User saveRecipe(int userId, Recipe recipe) {
        User user = findById(userId);
        user.getUserRecipes().add(recipe);
        return save(user);
    }

    public void delete(int id) throws NotFoundException {
        userRepository.delete(id);
    }

    public User get(int id) throws NotFoundException { // Returns instance without recipes
        User user = userRepository.get(id);
        user.setPassword("");
        return user;
    }

    @Override
    public User findById(int id) {  // Returns instance and recipes
        User user = userRepository.findById(id);
        user.setPassword("");
        return user;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }


    public User getByEmail(String email) throws NotFoundException {
        return userRepository.getByEmail(email);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void update(User user) {
        Assert.notNull(user, "User must not be null");
        userRepository.save(user);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.getByEmail(email.toLowerCase());
        if (u == null) {
            throw new UsernameNotFoundException("User" + email + " not found");
        }
        return new AuthorizedUser(u);
    }
}
