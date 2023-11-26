package eco.sustainnshare.webapp.impact;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImpactController {

    @GetMapping("/impact")
    public String getImpact(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "impact");
        model.addAttribute("isAuthenticated", authenticated);
        return "impact";
    }
}
