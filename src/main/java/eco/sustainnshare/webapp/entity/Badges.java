package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "Badges")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Badges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BadgeID")
    private int badgeId;
    @Column(name = "BadgeLocation")
    private String location;
    @Column(name = "BadgeDescription")
    private String description;
    @Column(name = "BadgeName")
    private String name;
}
