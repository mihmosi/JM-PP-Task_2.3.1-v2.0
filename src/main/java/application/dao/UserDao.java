package application.dao;

import application.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    User read(long id);

    List<User> getAllUsers();
}
