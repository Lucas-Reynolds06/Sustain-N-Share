package eco.sustainnshare.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties (ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int userID;
    private String username;
    private List<AuthorityDto> authorities = new ArrayList<>();
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String zipCode;
    private String password;
}
