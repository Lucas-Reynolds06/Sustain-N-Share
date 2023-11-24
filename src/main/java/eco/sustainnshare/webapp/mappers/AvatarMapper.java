package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.AvatarDto;
import eco.sustainnshare.webapp.entity.Avatar;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvatarMapper {

    public AvatarDto avatarEntityToDto(Avatar avatar) {
        return AvatarDto.builder()
                .location(avatar.getLocation())
                .id(avatar.getAvatarId())
                .build();
    }

    public List<AvatarDto> avatarEntitiesToDtos(List<Avatar> avatars) {
        return avatars.stream()
                .map(this::avatarEntityToDto)
                .toList();
    }
}
