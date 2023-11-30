package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.entity.Items;

import java.util.List;

public interface ItemsService {
    Items getItemByID(int id);
    ItemDto saveCreatedItem(CreateItemDto item);
    List<ItemDto> getSharedItemsByUser(int userID);
    List<ItemDto> getClaimedItemsByUser(int userID);
    int calculateImpactPoints(int userID);

    List<ItemDto> getRequestedItems(int userID);
}
