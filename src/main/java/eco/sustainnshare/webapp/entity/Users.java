package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "Users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "UserID")
    private int userID;
    @Column (name = "Username")
    private String username;
    @Column (name = "Email")
    private String email;
    @Column (name = "Password")
    private String password;
    @Column (name = "Address")
    private String address;
    @Column (name = "Phone")
    private String phone;
    @Column (name = "City")
    private String city;
    @ManyToOne
    @JoinColumn(name = "StateID")
    private States state;
    @Column (name = "ZipCode")
    private String zipCode;
    @Column (columnDefinition = "geometry(Point,4326)", name = "GeoLocation")
    private Point geoLocation;
    @ManyToOne
    @JoinColumn(name = "AvatarID")
    private Avatar avatar;
    @Column(name="ScreenName")
    private String screenName;

}
