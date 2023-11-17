package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "Locations")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Locations {
    @Id
    @Column (name = "LocationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationID;
    @Column (name = "Address")
    private String address;
    @Column (name = "City")
    private String city;
    @ManyToOne
    @JoinColumn(name = "StateID")
    private States state;
    @Column (name = "ZipCode")
    private String zipCode;
    @Column (columnDefinition = "geometry(Point,4326)", name = "GeoLocation")
    private Point geoLocation;
}
