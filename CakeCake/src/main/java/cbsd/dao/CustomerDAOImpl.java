package cbsd.dao;

import cbsd.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 27/2/2557.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired

    SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override

    public List<Customer> getCustomer() {
        return sessionFactory.getCurrentSession().createQuery("from Customer").list();
    }




    @Override
    public Customer findById(Integer id) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class,id);
    }




}
