package cbsd.Controller;

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

   @RequestMapping(method = RequestMethod.GET)
    public String Index(ModelMap model){
       return "index";
   }

}
