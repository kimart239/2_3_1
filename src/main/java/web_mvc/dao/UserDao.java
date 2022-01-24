package web_mvc.dao;

import web_mvc.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> userList();
    User findById(int id);
    void deleteById(int id);
    void delete(User user);
    void update (int id,User userUpdated);
}
