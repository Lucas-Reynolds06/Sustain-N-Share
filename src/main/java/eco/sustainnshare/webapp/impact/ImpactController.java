package eco.sustainnshare.webapp.impact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImpactController {

    @GetMapping("/impact")
    public String getImpact(Model model) {
        model.addAttribute("currentRoute", "impact");
        return "impact";
    }
}
