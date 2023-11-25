package eco.sustainnshare.webapp.blog;

import eco.sustainnshare.webapp.services.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BlogController {

    private final BlogPostService service;

    @GetMapping("/blog")
    public String getBlog(Model model) {
        model.addAttribute("posts", service.getPosts());
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String getPost(@PathVariable("id") Integer id, Model model) {
        var post = service.getBlogPostById(id);
        model.addAttribute("blogPost", post);
        return "blog-post";
    }
}
