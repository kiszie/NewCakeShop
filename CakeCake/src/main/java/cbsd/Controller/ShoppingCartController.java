package cbsd.Controller;

import cbsd.entity.Image;
import cbsd.entity.Product;
import cbsd.entity.ShoppingCart;
import cbsd.service.ImageService;
import cbsd.service.ShoppingCartService;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Dell on 28/2/2557.
 */
@Controller
@RequestMapping("shoppingcart")
@SessionAttributes({"userSession"})
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping("addToShoppingCart")
    public String callAddtPage(Model model){
        model.addAttribute("shoppingCart",new ShoppingCart());
        return "shoppingcart/addProduct1";
    }
    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("shoppingcarts", shoppingCartService.getShoppingCart());
        return "productList";

    }

    @RequestMapping("addProduct")
    public String addProduct(@ModelAttribute ShoppingCart shoppingCart, BindingResult bindingResult,Model model){
        shoppingCartService.addShoppingCart(shoppingCart);
        return "redirect:/product/list";
    }


    @RequestMapping(value = "addValidProduct",method = RequestMethod.POST)
    public String addValidProduct(@Valid Product product, BindingResult bindingResult,Model model
            ,@RequestParam("file")MultipartFile file){
        if (bindingResult.hasErrors()){
            return "product/addProduct1";


        }


        // add image object
        try {
            Image image = new Image();
            image.setFilename(file.getName());
            image.setContentType(file.getContentType());
            image.setContent(file.getBytes());
            product.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // image object add
        shoppingCartService.addShoppingCart(shoppingCart);
        return "redirect:/product/list";
    }

    @Autowired
    ImageService imageService;

    @RequestMapping(value = "image/{id}")
    public String showImage(@PathVariable("id") Integer id, Model model,
                            HttpServletResponse response){

        try {
            Image  image = imageService.get(id);
            if (image != null){
                OutputStream out = response.getOutputStream();
                response.setContentType(image.getContentType());
                //IOUtils.copy(new ByteArrayInputStream(image.getContent()),out);
                ByteArrayInputStream bis = new ByteArrayInputStream(image.getContent());
                ImageIO.setUseCache(false);
                BufferedImage myImage = ImageIO.read(bis);
                int rectangleSize = 300;
                BufferedImage bi = Scalr.resize(myImage, rectangleSize);
                ImageIO.write(bi,getContentType(image.getContentType()),out);
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private String getContentType(String contentType){
        if (contentType.contains("jpg")){
            return "jpg";
        }else if (contentType.contains("png")){
            return "png";
        }else if (contentType.contains("gif")){
            return "gif";
        }else{
            return "jpg";
        }

    }


}
