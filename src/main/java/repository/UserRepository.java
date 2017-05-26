package repository;


import javassist.NotFoundException;
import model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    // Null if not found
    User get (int id);

    // False if not found
    boolean delete (int id);

    List<User> getAll();

    User getByEmail(String email);
}
