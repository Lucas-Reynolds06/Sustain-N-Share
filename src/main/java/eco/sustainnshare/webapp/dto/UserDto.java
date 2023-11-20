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
    private int userID;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String zipCode;
}
