package eco.sustainnshare.webapp.wastereductiontips;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WasteReductionTipsController {
    @GetMapping("/waste-reduction-tips")
    public String wasteReductionTips(){
        return "waste-reduction-tips";
    }
}
