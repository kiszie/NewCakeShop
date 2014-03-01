package cbsd.dao;

import cbsd.service.ShoppingCartService;

import java.util.List;

/**
* Created by Dell on 1/3/2557.
*/
public interface ShoppingCartDAO {
    List<ShoppingCartService> getShoppingCart();

    void addShoppingCart(ShoppingCartService customer);

    ShoppingCartService findById(Integer id);
}
