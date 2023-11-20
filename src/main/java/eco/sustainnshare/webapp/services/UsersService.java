package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.entity.Users;

public interface UsersService {
    Users getUserByID(int id);
    Users createUser(UserDto userDto);
}
