package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.dto.SearchItemDto;

import java.util.List;

public interface ItemSearchService {
    List<ItemDto> searchItems(SearchItemDto searchItems);
    ItemDto getItem(Integer id);
}
