package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.BlogPostDto;
import eco.sustainnshare.webapp.mappers.BlogMapper;
import eco.sustainnshare.webapp.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogRepository repository;
    private final BlogMapper mapper;

    @Override
    public List<BlogPostDto> getPosts() {
        return mapper.blogPostsToDtos(repository.findAll());
    }

    @Override
    public BlogPostDto getBlogPostById(Integer id) {
        return mapper.blogPostToDto(repository.findById(id).get());
    }
}
