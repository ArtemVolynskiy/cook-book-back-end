package repository;


import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public User save(User user) {
        return new User();
    }

    public User get(int id) {
        return null;
    }

    public boolean delete(int id) {
        return false;
    }

    public List<User> getAll() {
        return null;
    }

    public User getByEmail(String email) {
        return null;
    }
}
