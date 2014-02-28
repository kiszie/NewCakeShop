package cbsd.Controller.formatter;

import cbsd.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import cbsd.service.CustomerService;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Dell on 27/2/2557.
 */
@Component
public class CustomerFormatter implements Formatter<Customer> {
    @Autowired
    CustomerService customerService;
    @Override
    public Customer parse(String s, Locale locale) throws ParseException {

        return customerService.findByID(Integer.parseInt(s));
    }

    @Override
    public String print(Customer customer, Locale locale) {

        return customer.getName();
    }
}