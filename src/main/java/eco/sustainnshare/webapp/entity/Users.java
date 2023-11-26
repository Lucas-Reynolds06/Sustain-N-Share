package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Column (name = "FirstName")
    private String firstName;
    @Column (name = "LastName")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "StateID")
    private States state;
    @Column (name = "ZipCode")
    private String zipCode;
    @Column (columnDefinition = "geometry(Point,4326)", name = "GeoLocation")
    private Point geoLocation;
    @Singular
    @ManyToMany (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable (name = "UserAuthorities", joinColumns = {
            @JoinColumn (name = "UserID")}, inverseJoinColumns = {
            @JoinColumn(name = "AuthorityID")
    })
    private List<Authorities> authorities = new ArrayList<>();
    private Boolean accountNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;
    private Boolean enabled = true;
    @ManyToOne
    @JoinColumn(name = "AvatarID")
    private Avatar avatar;
    @Column(name="ScreenName")
    private String screenName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserBadges> badges = new ArrayList<>();

}
