package eco.sustainnshare.webapp.sharingpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SharingPageController {
    @GetMapping("/sharing-page")
    public String sharingPage(Model model){

        return "sharing-page";
    }
}
