package cbsd.util;

import cbsd.dao.CustomerDAO;
import cbsd.dao.UserDAO;
import cbsd.entity.Product;
import cbsd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dell on 27/2/2557.
 */
@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {


        @Autowired
        CustomerDAO customerDAO;

        @Autowired
        UserDAO userDAO;
        boolean isLoad = false;
        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            //To change body of implemented methods use File | Settings | File Templates.
            if (!isLoad){





                // add the login data
                User user = new User();
                user.setUsername("beyonce");
                user.setName("BaiTong");
                user.setSurname("Surname");
                user.setAddress("225");
                // Actual password: admin
                user.setPassword("21232f297a57a5a743894a0e4a801fc3");

                // Admin user
                user.setRole(1);
                userDAO.saveUser(user);

                user = new User();
                user.setUsername("you");
                user.setName("BaiToey");
                user.setSurname("Surname");
                user.setAddress("225");

                // Actual password: user
                user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");

                // Regular user
                user.setRole(2);
                userDAO.saveUser(user);

                Product product = new Product();
                product.setName("cococo");
                product.setDes("BaiTong");
                user.setSurname("Surname");
                user.setAddress("225");
                // Actual password: admin
                user.setPassword("21232f297a57a5a743894a0e4a801fc3");
               isLoad = true;




        }
    }

}
