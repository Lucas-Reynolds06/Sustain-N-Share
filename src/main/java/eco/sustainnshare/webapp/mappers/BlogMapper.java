package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.BlogCommentDto;
import eco.sustainnshare.webapp.dto.BlogPostDto;
import eco.sustainnshare.webapp.entity.BlogComment;
import eco.sustainnshare.webapp.entity.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BlogMapper {

    public BlogPostDto blogPostToDto(BlogPost blogPost) {
        var comments = getCommentList(blogPost.getComments());
        return BlogPostDto.builder()
                .blogPostId(blogPost.getBlogPostId())
                .postAbstract(blogPost.getPostAbstract())
                .title(blogPost.getTitle())
                .content(blogPost.getContent())
                .avatarLocation(blogPost.getAuthor().getAvatar().getLocation())
                .category(blogPost.getCategory())
                .author(blogPost.getAuthor().getScreenName())
                .datePosted(blogPost.getDatePosted())
                .comments(comments)
                .imageLocation(blogPost.getImageLocation())
                .build();
    }

    public List<BlogPostDto> blogPostsToDtos(List<BlogPost> posts) {
        return posts.stream().map(this::blogPostToDto)
                .toList();
    }

    private List<BlogCommentDto> getCommentList(List<BlogComment> comments) {
        var commentList = new ArrayList<BlogCommentDto>();
        comments.forEach(comment -> {
            commentList.add(BlogCommentDto.builder()
                    .comment(comment.getComment())
                    .author(comment.getCommenter().getScreenName())
                    .avatarLocation(comment.getCommenter().getAvatar().getLocation())
                    .postedDate(comment.getDatePosted())
                    .build());
            ;
        });
        return commentList;
    }
}
