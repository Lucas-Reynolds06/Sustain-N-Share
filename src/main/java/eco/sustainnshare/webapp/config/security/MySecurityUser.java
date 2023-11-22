package eco.sustainnshare.webapp.config.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Getter
@Setter
public class MySecurityUser extends User {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private String fullName;

    public MySecurityUser(String username, String password, boolean enabled, boolean accountNonExpired,
                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
                          String firstName, String lastName, String email) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fullName = String.format("%s %s", firstName, lastName);
    }

    @Override
    public String toString() {
        return "MySecurityUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
