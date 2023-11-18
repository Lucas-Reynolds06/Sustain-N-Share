package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Conditions;
import eco.sustainnshare.webapp.repository.ConditionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConditionsServiceImpl implements ConditionsService {
    private final ConditionsRepository conditionsRepository;
    @Override
    public List<Conditions> getAllConditions() {
        return conditionsRepository.findAll();
    }
}
