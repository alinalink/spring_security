package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(long id, User user);

    User getById(long id);

    User deleteUser(long id);

    User getUserByName(String name);

}
