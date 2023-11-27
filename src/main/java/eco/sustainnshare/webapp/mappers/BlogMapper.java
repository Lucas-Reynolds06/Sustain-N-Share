package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.*;
import eco.sustainnshare.webapp.entity.BlogComment;
import eco.sustainnshare.webapp.entity.BlogHelpful;
import eco.sustainnshare.webapp.entity.BlogLikes;
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
                .likes(getLikeDto(blogPost.getLikes()))
                .helpfuls(getHelpfulDto(blogPost.getHelpful()))
                .build();
    }

    public List<BlogPostDto> blogPostsToDtos(List<BlogPost> posts) {
        return posts.stream().map(this::blogPostToDto)
                .toList();
    }

    private List<BlogLikeDto> getLikeDto(List<BlogLikes> likes) {
        var likeList = new ArrayList<BlogLikeDto>();
        likes.forEach(like -> {
            likeList.add(BlogLikeDto.builder()
                            .likedBy(like.getLikedBy().getUserID())
                    .build());
        });
        return likeList;
    }

    private List<BlogHelpfulDto> getHelpfulDto(List<BlogHelpful> helpfuls) {
        var likeList = new ArrayList<BlogHelpfulDto>();
        helpfuls.forEach(like -> {
            likeList.add(BlogHelpfulDto.builder()
                    .likedBy(like.getLikedBy().getUserID())
                    .build());
        });
        return likeList;
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


    public BlogComment commentDtoToBlogComment(BlogPostCommentDto postComment) {
        return BlogComment.builder()
                .comment(postComment.getComment())
                .build();

    }
}
