package cbsd.dao;

import cbsd.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 28/2/2557.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired

    SessionFactory sessionFactory;


    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);

    }

    @Override
    public List<Product> getProduct() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product findByID(Integer id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
    }
    @Override
    public void deleteById(Integer id) {
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class,id);
        if(null!=product){
            sessionFactory.getCurrentSession().delete(product);
        }
    }
}