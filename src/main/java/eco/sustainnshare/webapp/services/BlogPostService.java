package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.BlogPost;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getPosts();

    BlogPost getBlogPostById(Integer id);
}
