package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

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
    private int condition;
    private Date timeOnSite;
}
