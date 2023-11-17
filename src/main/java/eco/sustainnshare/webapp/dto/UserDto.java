package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@JsonIgnoreProperties (ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
}
