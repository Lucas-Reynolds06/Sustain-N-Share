package eco.sustainnshare.webapp.config.security;

import eco.sustainnshare.webapp.entity.Users;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findUsersByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new MySecurityUser(user.getUsername(), user.getPassword(), true, true, true, true,
                new HashSet<GrantedAuthority>(), "First","Last", user.getEmail());
    }
}