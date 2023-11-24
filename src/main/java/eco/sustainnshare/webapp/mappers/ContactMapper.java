package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.ContactDto;
import eco.sustainnshare.webapp.dto.StateDto;
import eco.sustainnshare.webapp.entity.Contact;
import eco.sustainnshare.webapp.entity.States;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public Contact contactDtoToEntity(ContactDto contactDto){
        return Contact.builder()
                .firstName(contactDto.getFirstName())
                .lastName(contactDto.getLastName())
                .email(contactDto.getEmail())
                .subject(contactDto.getSubject())
                .build();
    }
}
