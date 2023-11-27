package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BlogPost")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    @Id
    @Column(name = "BlogPostID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogPostId;
    @Column(name = "Title")
    private String title;
    @Column(name = "Abstract")
    private String postAbstract;
    @Column(name = "Content")
    private String content;
    @Column(name = "Category")
    private String category;
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Users author;
    @Column (name = "DatePosted")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePosted;
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BlogComment> comments;
    @Column(name = "ImageLocation")
    private String imageLocation;
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BlogLikes> likes;
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BlogHelpful> helpful;
}
