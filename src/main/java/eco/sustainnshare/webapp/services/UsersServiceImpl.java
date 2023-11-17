package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Users;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;

    @Override
    public Users getUserByID(int id) {
        var user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("User by ID " + id + " was not found");
    }
}
