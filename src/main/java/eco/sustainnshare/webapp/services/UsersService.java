package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.UserDto;

public interface UsersService {
    UserDto getUserByID(int id);
    UserDto createUser(UserDto userDto);
    UserDto getUserByUsername(String username);

    UserDto updateUser(UserDto userDto);

}
