package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties (ignoreUnknown = true)
public class SearchItemDto {
    private String searchText;
    private Integer category;
    private String city;
    private String state;
    private String zipCode;
    private Integer condition;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeOnSite;
    private Integer radius;
}
