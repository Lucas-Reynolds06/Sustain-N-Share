package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.AvatarDto;
import eco.sustainnshare.webapp.mappers.AvatarMapper;
import eco.sustainnshare.webapp.repository.AvatarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AvatarServiceImpl implements AvatarService {
    private final AvatarRepository avatarRepository;
    private final AvatarMapper mapper;


    @Override
    public List<AvatarDto> getAvatars() {
        return mapper.avatarEntitiesToDtos(avatarRepository.findAll());
    }
}
