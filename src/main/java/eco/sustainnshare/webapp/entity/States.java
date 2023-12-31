package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "States")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StateID")
    private int stateID;
    @Column(name = "Name")
    private String name;
}
