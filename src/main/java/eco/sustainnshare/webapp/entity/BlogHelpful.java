package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BlogHelpful")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogHelpful {
    @Id
    @Column(name = "BlogHelpfulID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogLikeID;
    @ManyToOne
    @JoinColumn(name = "LikedByID")
    private Users likedBy;
    @ManyToOne
    @JoinColumn(name = "BlogPostID")
    private BlogPost blogPost;
}