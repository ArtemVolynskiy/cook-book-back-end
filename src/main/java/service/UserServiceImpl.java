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

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    public User getByEmail(String email) throws NotFoundException {
        return repository.getByEmail(email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void update(User user) {
        Assert.notNull(user, "User must not be null");
        repository.save(user);
    }
}
