package service;


import javassist.NotFoundException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(int id) throws NotFoundException {
        userRepository.delete(id);
    }

    public User get(int id) throws NotFoundException {
        return userRepository.get(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
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
}
