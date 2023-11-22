package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.StateDto;
import eco.sustainnshare.webapp.entity.States;
import org.springframework.stereotype.Component;

@Component
public class StatesMapper {
    public StateDto stateEntityToDto(States state){
        return StateDto.builder()
                .stateID(state.getStateID())
                .name(state.getName())
                .build();
    }

    public States stateDtoToEntity(StateDto state){
        return States.builder()
                .stateID(state.getStateID())
                .name(state.getName())
                .build();
    }
}
