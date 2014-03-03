package cbsd.Controller;

import cbsd.entity.User;
import cbsd.service.CustomerService;
import cbsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Dell on 28/2/2557.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    UserService userService;

   @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model, final RedirectAttributes redirectAttributes){
//       UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       model.addAttribute("user", userDetails.getUsername());
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       User user = userService.findByUsername(authentication.getName());
       if(user != null){
           model.addAttribute("userSession",user);
           redirectAttributes.addFlashAttribute("userSession",user) ;
           return "index";
       }
       return "index";
   }


}
