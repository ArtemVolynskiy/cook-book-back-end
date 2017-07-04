package repository;


import model.Role;
import model.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.PasswordUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()){
            user.setPassword(PasswordUtil.encode(user.getPassword()));
            user.setRoles(new HashSet<Role>());
            user.getRoles().add(Role.ROLE_USER);
            user.getRoles().add(Role.ROLE_ADMIN);
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByName(String name) {
        return em.createNamedQuery(User.FIND_BY_NAME, User.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public User findById(int id) {
        return em.createNamedQuery(User.FIND_BY_ID, User.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(User.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }

    public User getByEmail(String email) {
        List<User> users = em.createNamedQuery(User.BY_EMAIL, User.class).setParameter(1, email).getResultList();
        return DataAccessUtils.singleResult(users);
    }
}
