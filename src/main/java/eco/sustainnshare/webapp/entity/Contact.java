package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Contact")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    @Id
    @Column (name = "ContactID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactID;
    @Column (name = "FirstName")
    private String firstName;
    @Column (name = "LastName")
    private String lastName;
    @Column (name = "Email")
    private String email;
    @ManyToOne
    @JoinColumn (name = "StateID")
    private States state;
    @Column (name = "Subject")
    private String subject;
}
