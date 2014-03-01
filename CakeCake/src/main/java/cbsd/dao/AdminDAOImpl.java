package cbsd.dao;

import cbsd.entity.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 28/2/2557.
 */
@Repository
public class AdminDAOImpl implements AdminDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addAdmin(Admin admin) {
        sessionFactory.getCurrentSession().saveOrUpdate(admin);

    }

    @Override
    public List<Admin> getAdmin() {
        return sessionFactory.getCurrentSession().createQuery("from Admin").list();
    }

    @Override
    public Admin findByID(Integer id) {
        return (Admin) sessionFactory.getCurrentSession().get(Admin.class,id);
    }
}
