package eco.sustainnshare.webapp.faqs;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrequentlyAskedQuestionsController {
    @GetMapping("/faqs")
    public String faqs(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "faqs");
        model.addAttribute("isAuthenticated", authenticated);
        return "faqs";
    }
}
