//package cbsd.dao;
//
//import cbsd.entity.Admin;
//import cbsd.entity.Customer;
//import cbsd.entity.User;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
//* Created by Dell on 2/3/2557.
//*/
//@Repository
//public class HistoryDAOImpl implements HistoryDAO {
//    @Autowired
//
//    SessionFactory sessionFactory;
//
//
//    @Override
//    public User findCustomerByUsername(String username) {
//        User user = (User) sessionFactory.getCurrentSession().createQuery
//                ("from User u where u.username = '" + username +"'").uniqueResult();
//        return user;
//    }
//
//    @Override
//    public void findCustomerByDate(Customer date) {
//
//    }
//
//    @Override
//    public List<Customer> getCustomer() {
//        return null;
//    }
//
//    @Override
//    public Admin findByID(Integer id) {
//        return null;
//    }
//}
