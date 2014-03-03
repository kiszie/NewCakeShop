package cbsd.Controller;

import cbsd.entity.Image;
import cbsd.entity.Product;
import cbsd.entity.User;
import cbsd.service.ImageService;
import cbsd.service.ProductService;
import cbsd.service.UserService;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@RequestMapping("product")
@SessionAttributes({"userSession"})
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @RequestMapping("enter")
        public String callHomepage(Model model){
            model.addAttribute("product",new Product());
            return "index(User)";
    }

    @RequestMapping("add")
    public String callAddProductPage(Model model, final RedirectAttributes redirectAttributes){
        model.addAttribute("product",new Product());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "product/addProduct1";
        }
        return "product/addProduct1";
    }
    @RequestMapping("list")
    public String list(Model model, final RedirectAttributes redirectAttributes){
        model.addAttribute("products", productService.getProduct());
        //UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       // model.addAttribute("user", userDetails.getUsername());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "productList";
        }

        return "productList";

    }

    @RequestMapping("addProduct")
    public String addProduct(@ModelAttribute Product product, BindingResult bindingResult,Model model, final RedirectAttributes redirectAttributes){
        productService.addProduct(product);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "redirect:/product/list";
        }
        return "redirect:/product/list";
    }


    @RequestMapping(value = "addValidProduct",method = RequestMethod.POST)
    public String addValidProduct(@Valid Product product, BindingResult bindingResult,Model model
            ,@RequestParam("file")MultipartFile file, final RedirectAttributes redirectAttributes){
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
        productService.addProduct(product);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "redirect:/product/list";
        }
        return "redirect:/product/list";
    }

    @RequestMapping(value = "update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Model model, final RedirectAttributes redirectAttributes){
        Product product = productService.findByID(id);
        model.addAttribute("product",product);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "redirect:/product/list";
        }
        return "product/addProduct1";
    }

    @RequestMapping(value = "delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model, final RedirectAttributes redirectAttributes){
        productService.deleteById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "redirect:/product/list";
        }

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
