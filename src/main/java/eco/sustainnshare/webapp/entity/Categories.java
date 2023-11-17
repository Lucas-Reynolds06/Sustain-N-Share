package eco.sustainnshare.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Categories")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @Column (name = "CategoryID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int categoryID;
    @Column (name = "Name")
    private String name;
}
