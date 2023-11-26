package eco.sustainnshare.webapp.communitystories;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityStoriesController {

    @GetMapping("/community-stories")
    public String communityStories(Model model){
        model.addAttribute("currentRoute", "community-stories");
        return "community-stories";
    }
}
