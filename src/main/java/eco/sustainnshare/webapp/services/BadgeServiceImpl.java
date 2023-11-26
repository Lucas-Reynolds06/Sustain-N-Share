package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Badges;
import eco.sustainnshare.webapp.repository.BadgesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BadgeServiceImpl implements BadgeService {

    private final BadgesRepository repository;
    @Override
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
    @Override
    public Badges getAdvocateBadge(){
        return repository.findByName("Recycling Advocate");
    }
    @Override
    public Badges getVarietyBadge(){
        return repository.findByName("Variety Donor");
    }
    @Override
    public Badges getCommenterBadge(){
        return repository.findByName("Engaged Commenter");
    }
    @Override
    public Badges getMemberBadge(){
        return repository.findByName("New Member");
    }
    @Override
    public Badges getWarriorBadge(){
        return repository.findByName("Eco Warrior");
    }
}
