package cbsd.service;

import cbsd.entity.Product;
import cbsd.entity.ShoppingCart;

import java.util.List;

/**
 * Created by Dell on 3/3/2557.
 */
public interface ShoppingCartService {
    public void addShoppingcart(ShoppingCart shoppingCart);
    public List<ShoppingCart> getShoppingCart();
    Product findByID(Integer id);
}
