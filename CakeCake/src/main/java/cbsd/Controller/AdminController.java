package cbsd.Controller;

import cbsd.entity.Admin;
import cbsd.entity.Image;
import cbsd.entity.Product;
import cbsd.service.AdminService;
import cbsd.service.ImageService;
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
 * Created by Dell on 27/2/2557.
 */
@Controller
@RequestMapping("admin")
@SessionAttributes({"userSession"})
public class AdminController {


    @Autowired
    AdminService adminService;

    @RequestMapping("enter")
    public String callHomepage(Model model){
        model.addAttribute("Admin",new Admin());
        return "index(Admin)";
    }



//    @RequestMapping("register")
//    public String callRegistPage(Model model){
//        model.addAttribute("customer",new Customer());
//        return "customer/register";
//    }
    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("admins", adminService.getAdmin());
        return "AdminList";

    }
    @RequestMapping("addProduct")
    public String callAddProductController(Model model){
        model.addAttribute("product",new Product());
        return "product/addProduct1";
    }

    @RequestMapping("addAdmin")
    public String addAdmin(@ModelAttribute Admin admin, BindingResult bindingResult,Model model){
        adminService.addAdmin(admin);
        return "redirect:/admin/list";
    }


    @RequestMapping(value = "addValidAdmin",method = RequestMethod.POST)
    public String addValidAdmin(@Valid Admin admin, BindingResult bindingResult,Model model
            ,@RequestParam("file")MultipartFile file){
        if (bindingResult.hasErrors()){
            return "admin/register";


        }


        // add image object
        try {
            Image image = new Image();
            image.setFilename(file.getName());
            image.setContentType(file.getContentType());
            image.setContent(file.getBytes());
            admin.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // image object add
        adminService.addAdmin(admin);
        return "redirect:/admin/list";
    }

    @RequestMapping(value = "update/{id}")
    public String updateAdmin(@PathVariable("id") Integer id, Model model){
        Admin admin = adminService.findByID(id);
        model.addAttribute("customer",admin);

        return "adminRegist";
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
