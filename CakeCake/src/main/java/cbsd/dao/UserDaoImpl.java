package cbsd.dao;

import cbsd.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/10/13
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User findByName(String name) {
        return (User)sessionFactory.getCurrentSession().createQuery("from User u where u.name like :name")
                .setString("name", name).uniqueResult();

    }

    @Override
    public User findByUsername(String username) {
        User user = (User) sessionFactory.getCurrentSession().createQuery
                ("from User u where u.username = '" + username +"'").uniqueResult();
        return user;
    }

    @Override
    public void saveUser(User user) {
         sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);

    }

    @Override
    public List<User> getUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

}
