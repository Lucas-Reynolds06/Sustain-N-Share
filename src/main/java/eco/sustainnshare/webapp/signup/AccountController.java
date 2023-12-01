package eco.sustainnshare.webapp.signup;

import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.dto.SignInDto;
import eco.sustainnshare.webapp.dto.TransactionDto;
import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final UsersService userService;
    private final StateService stateService;
    private final AvatarService avatarService;
    private final ItemsService itemsService;
    private final BlogPostService blogPostService;

    @PostMapping("/sign-up")
    public String signUp(Model model, UserDto userDto, RedirectAttributes redirectAttributes) {
        try {
            var user = userService.createUser(userDto);
            redirectAttributes.addFlashAttribute("registrationSuccess", "Registration successful. Please sign in.");
            return "redirect:/sign-up";
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
        return signUp(userDetails, model);
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
        var otherPeopleRequestedItems = itemsService.getOtherPeopleRequestedItems(user.getUserID());
        var myRequestedItems = itemsService.getMyRequestedItems(user.getUserID());
        int commentCount = 0;
        for(var post : blogPostComments) {
            for(var comment: post.getComments()) {
                if(comment.getAuthor().equals(user.getScreenName())){
                    commentCount++;
                }
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("avatars", avatars);
        model.addAttribute("states", states);
        model.addAttribute("items", items);
        model.addAttribute("receivedItems", claimed);
        model.addAttribute("impactPoints",impactPoints);
        model.addAttribute("isAuthenticated", authenticated);
        model.addAttribute("blogComments", commentCount);
        model.addAttribute("otherPeopleRequestedItems", otherPeopleRequestedItems);
        model.addAttribute("myRequestedItem", myRequestedItems);

        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(Model model, UserDto userDto,RedirectAttributes redirectAttributes) {
        UserDto user = userService.updateUser(userDto);
        redirectAttributes.addFlashAttribute("registrationSuccess", "Registration successful. Please sign in.");
        return "redirect:/profile";
    }

    @GetMapping("/view-my-donated-item/{id}")
    public String searchItems(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") Integer id, Model model){
        var authenticated = userDetails != null;
        var item = itemsService.getItemById(id);
        model.addAttribute("currentRoute", "profile");
        model.addAttribute("item", item);
        model.addAttribute("isAuthenticated", authenticated);
        return "view-item";
    }

    @GetMapping("/view-items-others-want/{id}")
    public String searchOthersItems(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") Integer id, Model model){
        var authenticated = userDetails != null;
        var item = itemsService.getItemById(id);
        var transaction = itemsService.getRequestTransactionByItem(id);
        model.addAttribute("currentRoute", "profile");
        model.addAttribute("item", item);
        model.addAttribute("transaction", transaction);
        model.addAttribute("isAuthenticated", authenticated);
        return "view-others-item";
    }

    @PostMapping("/approve-item/{id}")
    public String approveItem(Model model, RedirectAttributes redirectAttributes, TransactionDto transactionDto, @PathVariable("id") Integer id) {
        itemsService.approveItemByTransactionId(id);
        return "redirect:/profile";
    }

    @PostMapping("/deny-item/{id}")
    public String denyItem(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") Integer id) {
        itemsService.denyItemByTransactionId(id);
        return "redirect:/profile";
    }
}
