//package cbsd.Controller;
//
//import cbsd.entity.Product;
//import cbsd.entity.ShoppingCart;
//import cbsd.service.ShoppingCartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
///**
// * Created by Dell on 28/2/2557.
// */
//@Controller
//@RequestMapping("shoppingcart")
//@SessionAttributes({"userSession"})
//public class ShoppingCartController {
//
//    @Autowired
//    ShoppingCartService shoppingCartService;
//
//    @RequestMapping("enter")
//    public String callHomepage(Model model){
//        model.addAttribute("product",new Product());
//        return "index(User)";
//    }
//
//    @RequestMapping("add")
//    public String callAddProductPage(Model model){
//        model.addAttribute("product",new Product());
//        return "shoppingcart/Shoppingcart";
//    }
//    @RequestMapping("list")
//    public String list(Model model){
//        model.addAttribute("shoppingcarts", shoppingCartService.getShoppingCart());
//        return "ShoppingCartList";
//
//    }
//
//    @RequestMapping("addProduct")
//    public String addShoppingCart(@ModelAttribute ShoppingCart shoppingCart, BindingResult bindingResult,Model model){
//        shoppingCartService.addShoppingCart(shoppingCart);
//        return "redirect:/shoppingcart/list";
//    }
//
//
//
//
//
//
//}
