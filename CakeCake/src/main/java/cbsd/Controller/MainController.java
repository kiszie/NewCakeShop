package cbsd.Controller;

import cbsd.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dell on 28/2/2557.
 */
@Controller
@RequestMapping("/")
public class MainController {
    CustomerService customerService;

   @RequestMapping(method = RequestMethod.GET)
    public String Index(ModelMap model){
       return "index";
   }




}
