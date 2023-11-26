package eco.sustainnshare.webapp.howitworks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HowItWorksController {
    @GetMapping("/how-it-works")
    public String howItWorks(Model model){
        model.addAttribute("currentRoute", "how-it-works");
        return "how-it-works";
    }
}
