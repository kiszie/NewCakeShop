package cbsd.dao;

import cbsd.entity.Customer;

import java.util.List;

/**
 * Created by Dell on 27/2/2557.
 */
public interface CustomerDAO {

    public void addCustomer(Customer customer);
    public List<Customer> getCustomer();
    Customer findById(Integer id);



}
