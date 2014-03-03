package cbsd.Controller;

//import cbsd.entity.History;
import cbsd.entity.Image;
import cbsd.entity.User;
import cbsd.service.ImageService;
import cbsd.service.UserService;
import cbsd.service.UserServiceImpl;
import cbsd.service.security.UserDetailServiceImpl;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/3/13
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("user")
//@SessionAttributes({"userSession","date"})
public class UserController {
    @Autowired
    UserService userService;

    @ModelAttribute("userSession")
    public User getUserSession(ModelMap model){

        return new User();
    }

//    @ModelAttribute("date")
//    public Date getUserDate()
//    {
//        return Calendar.getInstance().getTime();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user",new User());
        return "/user/userRegister";
    }


    @RequestMapping("register1")
    public String callRegistPage(Model model){
        model.addAttribute("user",new User());

        return "register";
    }
    @RequestMapping("list")
    public String list(Model model, final RedirectAttributes redirectAttributes){
        //UserDetailServiceImpl userDetailService = new UserDetailServiceImpl();
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("users", userService.getUser());
//        model.addAttribute("user", userDetails.getUsername());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "CustomerList";
        }
        return "CustomerList";

    }

    @RequestMapping("addUser")
    public String addUser(@ModelAttribute User user, BindingResult bindingResult,Model model){
        userService.addUser(user);
        return "redirect:/user/list";
    }


    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@ModelAttribute User user, BindingResult bindingResult,Model model,final RedirectAttributes redirectAttributes){
        model.addAttribute("userSession",user);
        redirectAttributes.addFlashAttribute("userSession",user);
        return "redirect:/lecturer/list";
    }


    @RequestMapping(value = "addValidUser",method = RequestMethod.POST)
    public String addValidUser(@Valid User user, BindingResult bindingResult,Model model
            ,@RequestParam("file")MultipartFile file, final RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "register";
        }
        // add image object

        try {
            Image image = new Image();
            image.setFilename(file.getName());
            image.setContentType(file.getContentType());
            image.setContent(file.getBytes());
            user.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // image object add
        String source = user.getPassword();
        String md5 = null;

        try {
            MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
            mdEnc.update(source.getBytes(), 0, source.length());
            md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
        } catch (Exception ex) {
            return null;
        }
        user.setPassword(md5);

       // userService.addUser(user);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user = userService.findByUsername(authentication.getName());
        if(user != null){
            model.addAttribute("userSession",user);
            redirectAttributes.addFlashAttribute("userSession",user) ;
            return "redirect:/";
        }

        return "redirect:/";
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
