package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.repository.BadgesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BadgeServiceImpl implements BadgeService {

    private final BadgesRepository repository;
}
