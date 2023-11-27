package eco.sustainnshare.webapp.signup;

import eco.sustainnshare.webapp.dto.SignInDto;
import eco.sustainnshare.webapp.dto.TransactionDto;
import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.mappers.UsersMapper;
import eco.sustainnshare.webapp.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final UsersService userService;
    private final StateService stateService;
    private final AvatarService avatarService;
    private final ItemsService itemsService;
    private final BlogPostService blogPostService;
    private final ItemSearchService itemSearchService;
    private final UsersMapper usersMapper;

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
    public String signUp(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var authenticated = userDetails != null;
        var states = stateService.getStates();
        model.addAttribute("user", new UserDto());
        model.addAttribute("states", states);
        model.addAttribute("currentRoute", "sign-up");
        model.addAttribute("isAuthenticated", authenticated);
        return "sign-up";
    }

    @GetMapping("/sign-in")
    public String signIn(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var authenticated = userDetails != null;
        model.addAttribute("user", new SignInDto());
        model.addAttribute("currentRoute", "sign-in");
        model.addAttribute("isAuthenticated", authenticated);
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String signIn(Model model, SignInDto userDto) {
        return "";
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "profile");
        var user = userService.getUserByUsername(userDetails.getUsername());
        var avatars = avatarService.getAvatars();
        var states = stateService.getStates();
        var items = itemsService.getSharedItemsByUser(user.getUserID());
        var claimed = itemsService.getClaimedItemsByUser(user.getUserID());
        var impactPoints = itemsService.calculateImpactPoints(user.getUserID());
        var blogPostComments = blogPostService.getMyCommentedBlogs(user.getUserID());
        int commentCount = 0;
        for(var post : blogPostComments) {
            for(var comment: post.getComments()) {
                if(comment.getAuthor().equals(user.getScreenName())){
                    commentCount++;
                }
            }
        }
        List<TransactionDto> transactionDtos = itemSearchService.getRequestedItems(user.getUserID());
        model.addAttribute("user", user);
        model.addAttribute("avatars", avatars);
        model.addAttribute("states", states);
        model.addAttribute("items", items);
        model.addAttribute("receivedItems", claimed);
        model.addAttribute("impactPoints",impactPoints);
        model.addAttribute("isAuthenticated", authenticated);
        model.addAttribute("blogComments", commentCount);
        model.addAttribute("transactions", transactionDtos);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(Model model, UserDto userDto,RedirectAttributes redirectAttributes) {
        UserDto user = userService.updateUser(userDto);
        redirectAttributes.addFlashAttribute("registrationSuccess", "Registration successful. Please sign in.");
        return "redirect:/profile";
    }
}
