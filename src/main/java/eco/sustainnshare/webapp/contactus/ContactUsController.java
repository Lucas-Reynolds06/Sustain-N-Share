package eco.sustainnshare.webapp.contactus;

import eco.sustainnshare.webapp.dto.ContactDto;
import eco.sustainnshare.webapp.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactUsController {
    private final ContactService contactService;

    @GetMapping("/contact-us")
    public String contactUs(Model model){
        var contactDto = new ContactDto();
        model.addAttribute("contact", contactDto);
        return "contact-us";
    }

    @PostMapping("/contact-us")
    public String contactUs(Model model, ContactDto contact){
        contactService.saveContactUsInfo(contact);
        return "contact-us";
    }
}
