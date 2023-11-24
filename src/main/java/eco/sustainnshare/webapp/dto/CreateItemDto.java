package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateItemDto {
    private String itemName;
    private String description;
    private Integer category;
    private Integer condition;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateListed;
    private String itemImage;
}
