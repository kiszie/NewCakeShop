package cbsd.dao;

import cbsd.entity.ShoppingCart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 3/3/2557.
 */
@Repository
public class ShoppingCartDAOImpl implements ShoppingCartDAO {
   @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addShoppingcart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().saveOrUpdate(shoppingCart);
    }

    @Override
    public List<ShoppingCart> getShoppingCart() {
        return sessionFactory.getCurrentSession().createQuery("from ShoppingCart").list();
    }

    @Override
    public ShoppingCart findByID(Integer id) {
        return (ShoppingCart) sessionFactory.getCurrentSession().get(ShoppingCart.class,id);
    }
}
