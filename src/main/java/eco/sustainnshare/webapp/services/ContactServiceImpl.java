package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.ContactDto;
import eco.sustainnshare.webapp.mappers.ContactMapper;
import eco.sustainnshare.webapp.repository.ContactRepository;
import eco.sustainnshare.webapp.repository.StatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    private final ContactRepository contactRepository;
    private final StatesRepository statesRepository;
    private final ContactMapper contactMapper;
    @Override
    public boolean saveContactUsInfo(ContactDto contactDto) {
        var state = statesRepository.findStateByName(contactDto.getState());
        var contact = contactMapper.contactDtoToEntity(contactDto);
        contact.setState(state);
        contact = contactRepository.save(contact);
        return true;
    }
}
