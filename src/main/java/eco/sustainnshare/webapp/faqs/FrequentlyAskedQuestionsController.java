package eco.sustainnshare.webapp.faqs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrequentlyAskedQuestionsController {
    @GetMapping("/faqs")
    public String faqs(Model model){
        model.addAttribute("currentRoute", "faqs");
        return "faqs";
    }
}
