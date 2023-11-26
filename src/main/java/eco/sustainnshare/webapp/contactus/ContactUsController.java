package eco.sustainnshare.webapp.contactus;

import eco.sustainnshare.webapp.dto.ContactDto;
import eco.sustainnshare.webapp.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactUsController {
    private final ContactService contactService;

    @GetMapping("/contact-us")
    public String contactUs(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var authenticated = userDetails != null;
        var contactDto = new ContactDto();
        model.addAttribute("currentRoute", "contact-us");
        model.addAttribute("contact", contactDto);
        model.addAttribute("isAuthenticated", authenticated);
        return "contact-us";
    }

    @PostMapping("/contact-us")
    public String contactUs(Model model, ContactDto contact){
        contactService.saveContactUsInfo(contact);
        return "contact-us";
    }
}
