package eco.sustainnshare.webapp.sharingpage;

import eco.sustainnshare.webapp.dto.SearchItemDto;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.services.ItemSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemSearchService itemSearchService;
    @PostMapping ("/search-items")
    public String searchItems(Model model, SearchItemDto searchItems){
        List<Items> items = itemSearchService.searchItems(searchItems);
        return "items";
    }
}
