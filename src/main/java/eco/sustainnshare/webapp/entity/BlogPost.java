package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
