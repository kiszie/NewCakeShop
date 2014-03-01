package cbsd.Controller.formatter;

import cbsd.entity.Admin;
import cbsd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Dell on 28/2/2557.
 */
@Component
public class AdminFormatter implements Formatter<Admin> {
    @Autowired
    AdminService adminService;
    @Override
    public Admin parse(String s, Locale locale) throws ParseException {

        return adminService.findByID(Integer.parseInt(s));
    }

    @Override
    public String print(Admin admin, Locale locale) {

        return admin.getName();
    }
}
