package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.SearchItemDto;
import eco.sustainnshare.webapp.entity.Items;

import java.util.List;

public interface ItemSearchService {
    List<Items> searchItems(SearchItemDto searchItems);
}
