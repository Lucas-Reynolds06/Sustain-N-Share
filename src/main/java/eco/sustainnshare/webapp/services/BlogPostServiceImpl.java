package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.BlogPostCommentDto;
import eco.sustainnshare.webapp.dto.BlogPostDto;
import eco.sustainnshare.webapp.entity.BlogComment;
import eco.sustainnshare.webapp.entity.BlogHelpful;
import eco.sustainnshare.webapp.entity.BlogLikes;
import eco.sustainnshare.webapp.entity.UserBadges;
import eco.sustainnshare.webapp.mappers.BlogMapper;
import eco.sustainnshare.webapp.repository.BlogPostCommentRepository;
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
    private final BlogPostCommentRepository blogPostCommentRepository;
    private final BadgeService badgeService;


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
        if (blogPostCommentRepository.findAllByCommenter(user).isEmpty()){
            user.getBadges().add(UserBadges.builder()
                            .user(user)
                            .badge(badgeService.getCommenterBadge())
                            .dateIssued(new Date())
                    .build());
            usersRepository.save(user);
        }
        repository.save(blog);
    }

    @Override
    public int likePost(int userID, int postId) {
        var post = repository.findById(postId).get();
        var user = usersRepository.findById(userID).get();
        var like = BlogLikes.builder()
                .likedBy(user)
                .blogPost(post)
                .build();
        post.getLikes().add(like);
        repository.save(post);
        return post.getLikes().size();
    }

    @Override
    public int findPostHelpful(int userID, int postId) {
        var post = repository.findById(postId).get();
        var user = usersRepository.findById(userID).get();
        var helpful = BlogHelpful.builder()
                .likedBy(user)
                .blogPost(post)
                .build();
        post.getHelpful().add(helpful);
        repository.save(post);
        return post.getHelpful().size() + 1;
    }

}
