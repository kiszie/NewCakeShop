//package cbsd.service;
//
//import cbsd.dao.HistoryDAO;
//import cbsd.entity.Admin;
//import cbsd.entity.Customer;
//import cbsd.entity.History;
//import cbsd.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
//* Created by SONY on 3/3/2557.
//*/
//@Service
//public class HistoryServiceImpl implements HistoryService {
//    @Autowired
//    HistoryDAO historyDAO;
//
//    @Override
//    @Transactional
//    public User findCustomerByUsername(String username) {
//        return historyDAO.findCustomerByUsername(username);
//    }
//
//    @Override
//    @Transactional
//    public void findCustomerByDate(Customer date) {
//
//    }
//
//    @Override
//    @Transactional
//    public List<Customer> getCustomer() {
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public Admin findByID(Integer id) {
//        return null;
//    }
//}
