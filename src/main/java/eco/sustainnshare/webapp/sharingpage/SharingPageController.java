package eco.sustainnshare.webapp.sharingpage;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SharingPageController {
    @GetMapping("/sharing-page")
    public String sharingPage(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "sharing-page");
        model.addAttribute("isAuthenticated", authenticated);
        return "sharing-page";
    }
}
