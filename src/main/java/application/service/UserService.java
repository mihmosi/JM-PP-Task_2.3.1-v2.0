package application.service;

import application.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    User read(long id);

    List<User> getAllUsers();
}
