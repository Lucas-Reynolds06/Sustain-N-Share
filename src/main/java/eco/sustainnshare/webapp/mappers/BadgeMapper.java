package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.BadgeDto;
import eco.sustainnshare.webapp.entity.Badges;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BadgeMapper {

    public BadgeDto badgeEntityToDto(Badges badge) {
        return BadgeDto.builder()
                .name(badge.getName())
                .description(badge.getDescription())
                .location(badge.getLocation())
                .build();
    }

    public List<BadgeDto> badgesToDtos(List<Badges> badges) {
        return badges.stream()
                .map(this::badgeEntityToDto)
                .toList();
    }

}
