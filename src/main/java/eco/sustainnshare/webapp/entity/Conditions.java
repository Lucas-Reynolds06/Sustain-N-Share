package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Conditions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Conditions {
    @Id
    @Column (name = "ConditionID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int conditionID;
    @Column (name = "Name")
    private String name;
}
