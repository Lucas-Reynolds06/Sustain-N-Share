package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.BlogPostCommentDto;
import eco.sustainnshare.webapp.dto.BlogPostDto;

import java.util.List;

public interface BlogPostService {
    List<BlogPostDto> getPosts();

    BlogPostDto getBlogPostById(Integer id);
    void saveComment(int userID, BlogPostCommentDto postComment);
}
