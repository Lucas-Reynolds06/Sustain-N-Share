package eco.sustainnshare.webapp.howitworks;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HowItWorksController {
    @GetMapping("/how-it-works")
    public String howItWorks(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "how-it-works");
        model.addAttribute("isAuthenticated", authenticated);
        return "how-it-works";
    }
}
