package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "BlogComments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogComment {
    @Id
    @Column(name = "BlogCommentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogCommentID;
    @ManyToOne
    @JoinColumn(name = "CommenterID")
    private Users commenter;
    @Column(name = "Comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "BlogPostID")
    private BlogPost blogPost;
    @Column (name = "DatePosted")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePosted;
}
