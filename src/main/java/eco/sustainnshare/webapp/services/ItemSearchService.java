package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.dto.SearchItemDto;
import eco.sustainnshare.webapp.dto.TransactionDto;

import java.util.List;

public interface ItemSearchService {
    List<ItemDto> searchItems(SearchItemDto searchItems);
    ItemDto getItem(Integer id);

    TransactionDto requestItem(Integer user, Integer itemID);

    List<TransactionDto> getRequestedItems(int userID);
    }
