package cbsd.service;

import cbsd.entity.Customer;

import java.util.List;

/**
 * Created by Dell on 27/2/2557.
 */
public interface CustomerService {
    public void addCustomer(Customer customer);
    public List<Customer> getCustomer();
    Customer findByID(Integer id);
}
