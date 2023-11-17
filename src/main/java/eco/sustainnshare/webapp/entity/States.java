package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "States")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StateID")
    private int stateID;
    @Column(name = "Name")
    private String name;
}
