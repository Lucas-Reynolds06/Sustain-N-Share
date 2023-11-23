package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.ContactDto;

public interface ContactService {
    boolean saveContactUsInfo(ContactDto contact);
}
