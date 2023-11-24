package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.StateDto;
import eco.sustainnshare.webapp.mappers.StatesMapper;
import eco.sustainnshare.webapp.repository.StatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StateServiceImpl implements StateService {
    private final StatesRepository statesRepository;
    private final StatesMapper mapper;

    public List<StateDto> getStates(){
        var states = statesRepository.findAll();
        return mapper.statesEntitiesToDtos(states);
    }
}
