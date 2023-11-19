package eco.sustainnshare.webapp.impact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImpactController {

    @GetMapping("/impact")
    public String getImpact() {
        return "impact";
    }
}
