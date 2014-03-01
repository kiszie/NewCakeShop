//package cbsd.service;
//
//import cbsd.dao.ShoppingCartDAO;
//import cbsd.entity.ShoppingCart;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
//* Created by Dell on 1/3/2557.
//*/
//@Service
//public class ShoppingCartServiceServiceImpl implements ShoppingCartService {
//    @Autowired
//    ShoppingCartDAO shoppingCartDAO;
//
//    @Override
//    @Transactional
//    public void addShoppingCart(String shoppingCart) {
//        shoppingCartDAO.addShoppingCart(shoppingCart);
//    }
//
//
//
//    @Override
//    @Transactional
//    public List<ShoppingCartService> getShoppingCart() {
//        return shoppingCartDAO.getShoppingCart();
//    }
//
//    @Override
//    @Transactional
//    public ShoppingCartService findByID(Integer id) {
//        return  shoppingCartDAO.findById(id);
//    }
//}
