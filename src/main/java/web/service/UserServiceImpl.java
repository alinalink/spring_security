package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void updateUser(long id, User user) {
        userDAO.updateUser(id,user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public User deleteUser(long id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }
}

