package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Authorities")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "AuthorityID")
    private int authorityID;
    @Column (name = "Authority")
    private String authority;
}
