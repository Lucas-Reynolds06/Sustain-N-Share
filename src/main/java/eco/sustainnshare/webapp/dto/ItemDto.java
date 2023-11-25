package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Integer category;
    private Integer condition;
    private DonorDto donor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateListed;
    private String location;
    private String itemImage;
}
