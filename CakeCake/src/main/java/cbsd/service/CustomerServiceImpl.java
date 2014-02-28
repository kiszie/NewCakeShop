package cbsd.service;

import cbsd.dao.CustomerDAO;
import cbsd.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 27/2/2557.
 */
@Service
public class CustomerServiceImpl implements  CustomerService {
    @Autowired
    CustomerDAO customerDAO;
    @Override
    @Transactional
    public void addCustomer(Customer customer) {
         customerDAO.addCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> getCustomer() {
       return customerDAO.getCustomer();
    }

    @Override
    @Transactional
    public Customer findByID(Integer id) {
        return  customerDAO.findById(id);
    }
}
