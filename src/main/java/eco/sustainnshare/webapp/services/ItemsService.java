package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.entity.Items;

public interface ItemsService {
    Items getItemByID(int id);
    ItemDto saveCreatedItem(CreateItemDto item);
}
