package service;


import javassist.NotFoundException;
import model.UserInfo;
import model.Recipe;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import org.springframework.util.Assert;
import util.ratecounter.CaloriesUtil;
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

    @Override
    public void countCalories(UserInfo userInfo) throws NotFoundException {
        User user = get(AuthorizedUser.id());
        user.setCalories(CaloriesUtil.countDailyCalories(userInfo));
        userRepository.save(user);
    }


    public void delete(int id) throws NotFoundException {
        userRepository.delete(id);
    }

    public User get(int id) throws NotFoundException  { // Returns instance without recipes
        return userRepository.get(id);
    }

    @Override
    public User findById(int id) {  // Returns instance and recipes
        return userRepository.findById(id);
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

    @Override
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
