package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Items {
    @Id
    @Column (name = "ItemID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;
    @Column (name = "Name")
    private String name;
    @Column (name = "Description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Categories category;
    @ManyToOne
    @JoinColumn(name = "ConditionID")
    private Conditions condition;
    @ManyToOne
    @JoinColumn(name = "DonorID")
    private Users donor;
    @ManyToOne
    @JoinColumn(name = "ReceiverID")
    private Users receiver;
    @Column (name = "DateListed")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateListed;
    @Column (name = "DateClaimed")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateClaimed;
    @Column(name = "GeoLocation")
    private Point geoLocation;
    @Column(name = "ItemImage")
    private String itemImage;
}
