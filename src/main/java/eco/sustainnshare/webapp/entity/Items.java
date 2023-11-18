package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    @Column (name = "Condition")
    @ManyToOne
    @JoinColumn(name = "ConditionID")
    private Categories condition;
    @ManyToOne
    @JoinColumn(name = "DonorID")
    private Users donor;
    @ManyToOne
    @JoinColumn(name = "ReceiverID")
    private Users receiver;
    @Column (name = "DateListed")
    private Date dateListed;
    @Column (name = "DateClaimed")
    private Date dateClaimed;
    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Locations location;
}
