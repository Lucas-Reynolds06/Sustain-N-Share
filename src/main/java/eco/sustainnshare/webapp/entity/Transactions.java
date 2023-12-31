package eco.sustainnshare.webapp.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Transactions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transactions {
    @Id
    @Column (name = "TransactionID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int transactionID;
    @ManyToOne
    @JoinColumn(name = "ItemID")
    private Items item;
    @ManyToOne
    @JoinColumn(name = "DonorID")
    private Users donor;
    @ManyToOne
    @JoinColumn(name = "ReceiverID")
    private Users receiver;
    @Column (name = "DateInitiated")
    private Date dateInitiated;
    @Column (name = "DateCompleted")
    private Date dateCompleted;
    @Column (name = "Status")
    private String status;
}
