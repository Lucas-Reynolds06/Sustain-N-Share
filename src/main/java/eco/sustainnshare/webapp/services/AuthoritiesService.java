package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.AuthorityDto;
import eco.sustainnshare.webapp.entity.Authorities;

import java.util.List;

public interface AuthoritiesService {
    AuthorityDto getAuthorityById(Integer id);
    List<AuthorityDto> getAllAuthorities();
    AuthorityDto createAuthority(Authorities authority);
    AuthorityDto updateAuthority(Authorities authority);
    void deleteAuthority(Authorities authority);

}
