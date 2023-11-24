package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersMapper {
    private final AuthoritiesMapper authoritiesMapper;
    private final StatesMapper statesMapper;

    public UserDto userEntityToDto(Users user){
        //do not add password to this, it would leak to the front end, causing a security risk
        return UserDto.builder()
                .userID(user.getUserID())
                .username(user.getUsername())
                .authorities(authoritiesMapper.authorityListEntityToDto(user.getAuthorities().stream().toList()))
                .accountNonExpired(user.getAccountNonExpired())
                .accountNonLocked(user.getAccountNonLocked())
                .credentialsNonExpired(user.getCredentialsNonExpired())
                .enabled(user.getEnabled())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .city(user.getCity())
                .zipCode(user.getZipCode())
                .phone(user.getPhone())
                .screenName(user.getScreenName())
                .email(user.getEmail())
                .state(user.getState().getName())
                .avatarLocation(user.getAvatar().getLocation())
                .avatarId(user.getAvatar().getAvatarId())
                .build();
    }

    public List<UserDto> userListEntityToDto(List<Users> users){
        return users.stream()
                .map(this::userEntityToDto)
                .toList();
    }

    public Users userDtoToEntity(UserDto user){
        return Users.builder()
                .userID(user.getUserID())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authoritiesMapper.authorityListDtoToEntity(user.getAuthorities()))
                .accountNonExpired(user.getAccountNonExpired())
                .accountNonLocked(user.getAccountNonLocked())
                .credentialsNonExpired(user.getCredentialsNonExpired())
                .enabled(user.getEnabled())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .address(user.getAddress())
                .city(user.getCity())
                .zipCode(user.getZipCode())
                .phone(user.getPhone())
                .screenName(user.getScreenName())
                .build();
    }

    public List<Users> userListDtoToEntity(List<UserDto> users){
        return users.stream()
                .map(this::userDtoToEntity)
                .toList();
    }
}
