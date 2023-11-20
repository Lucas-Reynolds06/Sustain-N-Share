package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.entity.Users;
import eco.sustainnshare.webapp.repository.StatesRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;
    private final StatesRepository statesRepository;

    @Override
    public Users getUserByID(int id) {
        var user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("User by ID " + id + " was not found");
    }

    @Override
    public Users createUser(UserDto userDto) {
        var user = userRepository.findUsersByUsername(userDto.getUsername());
        if(user != null) {
            throw new RuntimeException("User name " + userDto.getUsername() + " is already taken");
        }
        user = userRepository.findUsersByUsername(userDto.getEmail());
        if(user != null) {
            throw new RuntimeException("Email already exists");
        }

        var state = statesRepository.findStateByName(userDto.getState());

        user = Users.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .address(userDto.getAddress())
                .city(userDto.getCity())
                .state(state)
                .zipCode(userDto.getZipCode())
                .build();

        return userRepository.save(user);
    }
}
