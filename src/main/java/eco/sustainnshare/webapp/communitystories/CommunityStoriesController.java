package eco.sustainnshare.webapp.communitystories;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityStoriesController {

    @GetMapping("/community-stories")
    public String communityStories(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "community-stories");
        model.addAttribute("isAuthenticated", authenticated);
        return "community-stories";
    }
}
