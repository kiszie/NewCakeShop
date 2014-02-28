package cbsd.Controller;

import cbsd.entity.Customer;
import cbsd.entity.Image;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import cbsd.service.CustomerService;
import cbsd.service.ImageService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Dell on 27/2/2557.
 */
@Controller
@RequestMapping("customer")
@SessionAttributes({"userSession","date"})
public class CustomerController {

    @ModelAttribute("userSession")
    public Customer getUserSession(){
        return new Customer();
    }

    @ModelAttribute("date")
    public Date getUserDate()
    {
        return Calendar.getInstance().getTime();
    }


        @Autowired
        CustomerService customerService;

        @RequestMapping("enter")
        public String callHomepage(Model model){
            model.addAttribute("customer",new Customer());
            return "index(User)";
        }



        @RequestMapping("register")
        public String callRegistPage(Model model){
            model.addAttribute("customer",new Customer());
            return "customer/register";
        }
        @RequestMapping("list")
        public String list(Model model){
            model.addAttribute("customers", customerService.getCustomer());
            return "customerList";

        }

        @RequestMapping("addCustomer")
        public String addLecturer(@ModelAttribute Customer customer, BindingResult bindingResult,Model model){
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
        }


        @RequestMapping(value = "addValidCustomer",method = RequestMethod.POST)
        public String addValidCustomer(@Valid Customer customer, BindingResult bindingResult,Model model
                ,@RequestParam("file")MultipartFile file){
            if (bindingResult.hasErrors()){
                return "register";
            }
            // add image object
            try {
                Image image = new Image();
                image.setFilename(file.getName());
                image.setContentType(file.getContentType());
                image.setContent(file.getBytes());
                customer.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // image object add
            customerService.addCustomer(customer);
            return "redirect:/customer/list";
        }

        @RequestMapping(value = "update/{id}")
        public String updateCustomer(@PathVariable("id") Integer id, Model model){
            Customer customer = customerService.findByID(id);
            model.addAttribute("customer",customer);

            return "customerRegist";
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
