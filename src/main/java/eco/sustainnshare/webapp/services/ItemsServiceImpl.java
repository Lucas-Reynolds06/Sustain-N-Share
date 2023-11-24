package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.entity.Users;
import eco.sustainnshare.webapp.mappers.ItemsMapper;
import eco.sustainnshare.webapp.repository.ItemsRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;
    private final ItemsMapper itemsMapper;
    private final UsersRepository usersRepository;
    @Override
    public Items getItemByID(int id) {
        var item = itemsRepository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        throw new RuntimeException("Item by ID " + id + " was not found");
    }

    @Override
    public ItemDto saveCreatedItem(CreateItemDto item){
        Items createdItem = itemsMapper.createdItemDtoToEntity(item);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users donor = usersRepository.findUsersByUsername(authentication.getName());
        createdItem.setDonor(donor);
        createdItem.setGeoLocation(donor.getGeoLocation());
        itemsRepository.save(createdItem);
        return itemsMapper.itemEntityToDto(createdItem);
    }
}
