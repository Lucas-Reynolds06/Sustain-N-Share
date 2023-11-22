package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.AuthorityDto;
import eco.sustainnshare.webapp.entity.Authorities;
import eco.sustainnshare.webapp.repository.AuthoritiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthoritiesServiceImpl implements AuthoritiesService{
    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public AuthorityDto getAuthorityById(Integer id) {
        return null;
    }

    @Override
    public List<AuthorityDto> getAllAuthorities() {
        return null;
    }

    @Override
    public AuthorityDto createAuthority(Authorities authority) {
        return null;
    }

    @Override
    public AuthorityDto updateAuthority(Authorities authority) {
        return null;
    }

    @Override
    public void deleteAuthority(Authorities authority) {
        authoritiesRepository.delete(authority);
    }
}
