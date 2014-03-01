package cbsd.dao;

import cbsd.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/10/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    User findByName(String name);
    User findByUsername(String username);
    void saveUser(User user);
    public void addUser(User user);
    public List<User> getUser();
}
