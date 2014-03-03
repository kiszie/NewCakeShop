package cbsd.service;

import cbsd.entity.Product;
import cbsd.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 3/3/2557.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired

    ShoppingCartDAO shoppingCartDAO();
    @Override
    @Transactional
    public void addShoppingcart(ShoppingCart shoppingCart) {
        shoppingCartDAO.addShoppingCart(shoppingCart);

    }

    @Override
    @Transactional
    public List<ShoppingCart> getShoppingCart() {
        return shoppingCartDAO.getShoppindCart();
    }

    @Override
    @Transactional
    public Product findByID(Integer id) {
        return shoppingCartDAO()findByID(id);
    }
}
