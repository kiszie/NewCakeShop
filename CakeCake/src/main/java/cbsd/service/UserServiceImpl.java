package cbsd.service;

import cbsd.dao.UserDAO;
import cbsd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/10/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    @Transactional
    @Override
    public User findByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public List<User> getUser() {
        return userDAO.getUser();
    }
}
