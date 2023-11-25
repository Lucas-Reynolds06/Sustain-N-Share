package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.BlogPostCommentDto;
import eco.sustainnshare.webapp.dto.BlogPostDto;
import eco.sustainnshare.webapp.entity.BlogComment;
import eco.sustainnshare.webapp.mappers.BlogMapper;
import eco.sustainnshare.webapp.repository.BlogRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogRepository repository;
    private final BlogMapper mapper;
    private final UsersRepository usersRepository;


    @Override
    public List<BlogPostDto> getPosts() {
        return mapper.blogPostsToDtos(repository.findAll());
    }

    @Override
    public BlogPostDto getBlogPostById(Integer id) {
        return mapper.blogPostToDto(repository.findById(id).get());
    }

    @Override
    public void saveComment(int userID, BlogPostCommentDto postComment) {
        var blog = repository.findById(postComment.getPostId()).get();

        var user = usersRepository.findById(userID).get();
        BlogComment comment = mapper.commentDtoToBlogComment(postComment);
        comment.setCommenter(user);
        comment.setBlogPost(blog);
        comment.setDatePosted(new Date());
        blog.getComments().add(comment);
        repository.save(blog);

    }
}
