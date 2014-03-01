package cbsd.service;

import cbsd.dao.ProductDAO;
import cbsd.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 28/2/2557.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;
    @Override
    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    @Transactional
    public List<Product> getProduct() {
        return productDAO.getProduct();
    }

    @Override
    @Transactional
    public Product findByID(Integer id) {
        return  productDAO.findByID(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        productDAO.deleteById(id);
    }
}
