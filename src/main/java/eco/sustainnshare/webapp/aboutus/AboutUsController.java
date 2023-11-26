package eco.sustainnshare.webapp.aboutus;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
    @GetMapping("/about-us")
    public String aboutUs(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "about-us");
        model.addAttribute("isAuthenticated", authenticated);
        return "about-us";
    }
}
