package web_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_mvc.dao.UserDao;
import web_mvc.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void update (int id,User userUpdated) {
        userDao.update(id, userUpdated);
    }

}
