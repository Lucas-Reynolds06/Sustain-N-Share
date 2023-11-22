package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.AuthorityDto;
import eco.sustainnshare.webapp.entity.Authorities;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthoritiesMapper {
    public AuthorityDto authorityEntityToDto(Authorities authority){
        return AuthorityDto.builder()
                .id(authority.getAuthorityID())
                .authority(authority.getAuthority())
                .build();
    }

    public List<AuthorityDto> authorityListEntityToDto(List<Authorities> authorities){
        return authorities.stream()
                .map(this::authorityEntityToDto)
                .toList();
    }

    public Authorities authorityDtoToEntity(AuthorityDto authority){
        return Authorities.builder()
                .authorityID(authority.getId())
                .authority(authority.getAuthority())
                .build();
    }

    public List<Authorities> authorityListDtoToEntity(List<AuthorityDto> authorities){
        return authorities.stream()
                .map(this::authorityDtoToEntity)
                .toList();
    }
}
