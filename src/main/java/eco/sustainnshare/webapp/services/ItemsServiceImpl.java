package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.entity.Users;
import eco.sustainnshare.webapp.mappers.ItemsMapper;
import eco.sustainnshare.webapp.repository.CategoriesRepository;
import eco.sustainnshare.webapp.repository.ItemsRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users donor = usersRepository.findUsersByUsername(authentication.getName());
        // get current donated items to calculate status for badges
        var sharedItems = getSharedItemsByUser(donor.getUserID());
        Items createdItem = itemsMapper.createdItemDtoToEntity(item);
        createdItem.setDonor(donor);
        createdItem.setGeoLocation(donor.getGeoLocation());
        itemsRepository.save(createdItem);
        return itemsMapper.itemEntityToDto(createdItem);
    }

    @Override
    public List<ItemDto> getSharedItemsByUser(int userID) {
        var user = usersRepository.findById(userID).get();
        var items = itemsRepository.findAllByDonor(user);
        return itemsMapper.itemEntitiesToDtos(items);
    }

    @Override
    public List<ItemDto> getClaimedItemsByUser(int userID) {
        var user = usersRepository.findById(userID).get();
        var items = itemsRepository.findAllByReceiver(user);
        return itemsMapper.itemEntitiesToDtos(items);
    }

    @Override
    public int calculateImpactPoints(int userID){
        int total = 0;
        var user = usersRepository.findById(userID).get();
        var sharedItems = itemsRepository.findAllByDonor(user);
        for(var item : sharedItems){
            total += ImpactPoints.getPointsByCategory(item.getCategory().getName());
        }
        var receivedItems = itemsRepository.findAllByReceiver(user);
        for (var item : receivedItems){
            total += ImpactPoints.getPointsByCategory(item.getCategory().getName());
        }
        return total;
    }
}
