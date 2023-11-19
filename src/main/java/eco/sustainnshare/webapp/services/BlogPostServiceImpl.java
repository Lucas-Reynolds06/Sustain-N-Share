package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.BlogPost;
import eco.sustainnshare.webapp.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogRepository repository;

    @Override
    public List<BlogPost> getPosts() {
        return repository.findAll();
    }

    @Override
    public BlogPost getBlogPostById(Integer id) {
        return repository.findById(id).get();
    }
}
