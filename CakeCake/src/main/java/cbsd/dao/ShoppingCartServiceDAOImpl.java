package cbsd.dao;

import cbsd.service.ShoppingCartService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by Dell on 1/3/2557.
*/
@Repository
public class ShoppingCartServiceDAOImpl implements ShoppingCartService {
    @Autowired

    SessionFactory sessionFactory;

    @Override
    public void addShoppingCart(ShoppingCartService customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public List<ShoppingCartService> getShoppingCart() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public ShoppingCartService findByID(Integer id) {
        return null;
    }
}
