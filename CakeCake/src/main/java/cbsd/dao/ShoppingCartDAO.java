package cbsd.dao;

import cbsd.entity.Product;
import cbsd.entity.ShoppingCart;

import java.util.List;

/**
 * Created by Dell on 3/3/2557.
 */
public interface ShoppingCartDAO {
    public void addShoppingcart(ShoppingCart shoppingCart);
    public List<ShoppingCart> getShoppingCart();
    Product findByID(Integer id);

}
