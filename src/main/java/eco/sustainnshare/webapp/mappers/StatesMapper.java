package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.StateDto;
import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.entity.States;
import eco.sustainnshare.webapp.entity.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatesMapper {
    public StateDto stateEntityToDto(States state){
        return StateDto.builder()
                .stateID(state.getStateID())
                .name(state.getName())
                .build();
    }

    public List<StateDto> statesEntitiesToDtos(List<States> users){
        return users.stream()
                .map(this::stateEntityToDto)
                .toList();
    }

    public States stateDtoToEntity(StateDto state){
        return States.builder()
                .stateID(state.getStateID())
                .name(state.getName())
                .build();
    }


}
