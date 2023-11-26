package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table (name = "UserBadges")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserBadges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserBadgeID")
    private int userBadgeId;
    @ManyToOne
    @JoinColumn (name = "UserID")
    private Users user;
    @ManyToOne
    @JoinColumn (name = "BadgeID")
    private Badges badge;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DateIssued")
    private Date dateIssued;


}
