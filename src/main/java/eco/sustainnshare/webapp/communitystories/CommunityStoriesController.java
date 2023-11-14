package eco.sustainnshare.webapp.communitystories;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityStoriesController {
    @GetMapping("/community-stories")
    public String communityStories(){
        return "community-stories";
    }
}
