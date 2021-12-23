package web.dao;
import org.springframework.stereotype.Component;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select users from User users", User.class).getResultList();

    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
     public void updateUser(long id, User user) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User deleteUser(long id) {
        User user = getById(id);
        entityManager.remove(user);
        return user;
    }

    @Override
    public User getUserByName(String name) {
        return (User) entityManager.createQuery("select user from User user join fetch user.roles where user.name=:name")
                .setParameter("name", name).getSingleResult();
    }


}

