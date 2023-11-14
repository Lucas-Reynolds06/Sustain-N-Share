package eco.sustainnshare.webapp.signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    @GetMapping("/sign-in")
    public String signInOrUp(){
        return "sign-in-or-up";
    }
}
