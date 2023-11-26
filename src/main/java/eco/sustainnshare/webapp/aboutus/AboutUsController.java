package eco.sustainnshare.webapp.aboutus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
    @GetMapping("/about-us")
    public String aboutUs(Model model){
        model.addAttribute("currentRoute", "about-us");
        return "about-us";
    }
}
