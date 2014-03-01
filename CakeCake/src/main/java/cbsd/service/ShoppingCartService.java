package cbsd.service;

import java.util.List;

/**
 * Created by Dell on 1/3/2557.
 */
public interface ShoppingCartService {


    public void addShoppingCart(ShoppingCartService shoppingCart);


    public List<ShoppingCartService> getShoppingCart();


    ShoppingCartService findByID(Integer id);
}
