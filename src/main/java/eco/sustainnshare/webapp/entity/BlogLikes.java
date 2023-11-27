package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BlogLikes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogLikes {
    @Id
    @Column(name = "BlogLikeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogLikeID;
    @ManyToOne
    @JoinColumn(name = "LikedByID")
    private Users likedBy;
    @ManyToOne
    @JoinColumn(name = "BlogPostID")
    private BlogPost blogPost;
}
