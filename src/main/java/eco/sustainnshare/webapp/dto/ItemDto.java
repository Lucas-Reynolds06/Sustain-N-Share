package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private int itemID;
    private String name;
    private String description;
    private String category;
    private String condition;
    private String donor;
    private Date dateListed;
    private String location;
}
