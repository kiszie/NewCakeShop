package cbsd.service;

import cbsd.entity.Product;

import java.util.List;

/**
 * Created by Dell on 28/2/2557.
 */
public interface ProductService {
    public void addProduct(Product product);
    public List<Product> getProduct();
    Product findByID(Integer id);
    void deleteById(Integer id);
}
