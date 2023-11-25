package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogPostDto {
    private int blogPostId;
    private String title;
    private String postAbstract;
    private String content;
    private String category;
    private String avatarLocation;
    private String author;
    private Date datePosted;
    private List<BlogCommentDto> comments;
    private String imageLocation;
}
