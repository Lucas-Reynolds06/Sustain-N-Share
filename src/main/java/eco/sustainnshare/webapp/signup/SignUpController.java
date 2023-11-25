package eco.sustainnshare.webapp.signup;

import eco.sustainnshare.webapp.dto.SignInDto;
import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.services.AvatarService;
import eco.sustainnshare.webapp.services.ItemsService;
import eco.sustainnshare.webapp.services.StateService;
import eco.sustainnshare.webapp.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final UsersService userService;
    private final StateService stateService;
    private final AvatarService avatarService;
    private final ItemsService itemsService;

    @PostMapping("/sign-up")
    public String signUp(Model model, UserDto userDto, RedirectAttributes redirectAttributes) {
        try {
            var user = userService.createUser(userDto);
            redirectAttributes.addFlashAttribute("registrationSuccess", "Registration successful. Please sign in.");
            return "redirect:/sign-in";
        } catch(RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "signup-failure";
        }
    }

    @GetMapping("/sign-up")
    public String signUp(Model model){
        var states = stateService.getStates();
        model.addAttribute("user", new UserDto());
        model.addAttribute("states", states);
        return "sign-up";
    }

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("user", new SignInDto());
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String signIn(Model model, SignInDto userDto) {

        return "";
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var user = userService.getUserByUsername(userDetails.getUsername());
        var avatars = avatarService.getAvatars();
        var states = stateService.getStates();
        var items = itemsService.getSharedItemsByUser(user.getUserID());
        var claimed = itemsService.getClaimedItemsByUser(user.getUserID());
        var impactPoints = itemsService.calculateImpactPoints(user.getUserID());
        model.addAttribute("user", user);
        model.addAttribute("avatars", avatars);
        model.addAttribute("states", states);
        model.addAttribute("items", items);
        model.addAttribute("receivedItems", claimed);
        model.addAttribute("impactPoints",impactPoints);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(Model model, UserDto userDto,RedirectAttributes redirectAttributes) {
        UserDto user = userService.updateUser(userDto);
        redirectAttributes.addFlashAttribute("registrationSuccess", "Registration successful. Please sign in.");
        return "redirect:/profile";
    }
}
