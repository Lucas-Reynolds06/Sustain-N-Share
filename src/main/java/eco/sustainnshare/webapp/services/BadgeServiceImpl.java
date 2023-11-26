package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Badges;
import eco.sustainnshare.webapp.repository.BadgesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BadgeServiceImpl implements BadgeService {

    private final BadgesRepository repository;
    public Badges getFirstTimeBadge(){
        return repository.findByName("First Donation");
    }
    @Override
    public Badges getFifthTimeBadge(){
        return repository.findByName("Fifth Donation");
    }
    @Override
    public Badges getTenthTimeBadge(){
        return repository.findByName("Tenth Donation");
    }
    @Override
    public Badges getTwentiethTimeBadge(){
        return  repository.findByName("Twentieth Donation");
    }
}
