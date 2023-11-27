package eco.sustainnshare.webapp.blog;

import eco.sustainnshare.webapp.dto.BlogPostCommentDto;
import eco.sustainnshare.webapp.services.BlogPostService;
import eco.sustainnshare.webapp.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class BlogController {

    private final BlogPostService service;
    private final UsersService userService;


    @GetMapping("/blog")
    public String getBlog(Model model) {
        model.addAttribute("currentRoute", "blog");
        model.addAttribute("posts", service.getPosts());
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String getPost(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") Integer id, Model model) {
        var authenticated = userDetails != null;
        var post = service.getBlogPostById(id);
        model.addAttribute("currentRoute", "blog");
        model.addAttribute("blogPost", post);
        model.addAttribute("isAuthenticated", authenticated);
        model.addAttribute("postComment", new BlogPostCommentDto());
        return "blog-post";
    }

    @PostMapping("/post-comment")
    public String updateProfile(@AuthenticationPrincipal UserDetails userDetails, Model model, BlogPostCommentDto postComment, RedirectAttributes redirectAttributes) {
        var user = userService.getUserByUsername(userDetails.getUsername());
        service.saveComment(user.getUserID(), postComment);
        redirectAttributes.addFlashAttribute("posted", "Posted the comment");
        return "redirect:/blog/" + postComment.getPostId();
    }


    @PostMapping("/like-post")
    @ResponseBody
    public String likePost(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("postId") int postId) {
        var user = userService.getUserByUsername(userDetails.getUsername());
        int updatedLikeCount = service.likePost(user.getUserID(), postId);
        return "{\"likes\": " + updatedLikeCount + "}";
    }

    @PostMapping("/helpful-post")
    @ResponseBody
    public String helpfulPost(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("postId") int postId) {
        var user = userService.getUserByUsername(userDetails.getUsername());
        int updateHelpfulCount = service.findPostHelpful(user.getUserID(), postId);
        return "{\"helpful\": " + updateHelpfulCount + "}";
    }

    @PostMapping("/addComment")
    @ResponseBody
    public String addComment(@AuthenticationPrincipal UserDetails userDetails,@ModelAttribute BlogPostCommentDto postComment) {
        var user = userService.getUserByUsername(userDetails.getUsername());
        service.saveComment(user.getUserID(), postComment);
        return "Comment added successfully";
    }
}
