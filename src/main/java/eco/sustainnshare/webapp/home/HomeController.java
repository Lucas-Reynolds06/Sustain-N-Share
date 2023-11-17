package eco.sustainnshare.webapp.home;

import eco.sustainnshare.webapp.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UsersService usersService;
    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("user", usersService.getUserByID(1));
        return "home";
    }

}
