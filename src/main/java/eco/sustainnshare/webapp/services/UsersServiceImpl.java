package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.mappers.UsersMapper;
import eco.sustainnshare.webapp.repository.AvatarRepository;
import eco.sustainnshare.webapp.repository.StatesRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;
    private final StatesRepository statesRepository;
    private final UsersMapper usersMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AvatarRepository avatarRepository;


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
        var hashedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setState(state);
        user.setPassword(hashedPassword);
        var avatar = avatarRepository.findAvatarByLocation("default.png");
        user.setAvatar(avatar);
        user =  userRepository.save(user);
        return usersMapper.userEntityToDto(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        var user = userRepository.findUsersByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return usersMapper.userEntityToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        var user = userRepository.findById(userDto.getUserID()).get();
        var mappedUser = usersMapper.userDtoToEntity(userDto);
        mappedUser.setUserID(user.getUserID());
        //did they change their password?
        if(userDto.getPassword().isEmpty()) {
            mappedUser.setPassword(user.getPassword());
        } else {
            var hashedPassword = passwordEncoder.encode(userDto.getPassword());
            mappedUser.setPassword(hashedPassword);
        }
        var avatar = avatarRepository.findById(userDto.getAvatarId()).get();
        var state = statesRepository.findStateByName(userDto.getState());
        mappedUser.setState(state);
        mappedUser.setAvatar(avatar);
        return usersMapper.userEntityToDto(userRepository.save(mappedUser));
    }
}
