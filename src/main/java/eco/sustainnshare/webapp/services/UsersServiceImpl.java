package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.mappers.UsersMapper;
import eco.sustainnshare.webapp.repository.StatesRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;
    private final StatesRepository statesRepository;
    private final UsersMapper usersMapper;


    @Override
    public UserDto getUserByID(int id) {
        var user = userRepository.findById(id);
        if (user.isPresent()){
            return usersMapper.userEntityToDto(user.get());
        }
        throw new RuntimeException("User by ID " + id + " was not found");
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        var user = userRepository.findUsersByUsername(userDto.getUsername());
        if(user != null) {
            throw new RuntimeException("User name " + userDto.getUsername() + " is already taken");
        }
        user = userRepository.findUsersByUsername(userDto.getEmail());
        if(user != null) {
            throw new RuntimeException("Email already exists");
        }



        user = usersMapper.userDtoToEntity(userDto);
        var state = statesRepository.findStateByName(userDto.getState());
        user.setState(state);
        user =  userRepository.save(user);
        return usersMapper.userEntityToDto(user);
    }
}
