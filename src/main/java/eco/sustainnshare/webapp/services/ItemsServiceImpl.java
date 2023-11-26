package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.entity.UserBadges;
import eco.sustainnshare.webapp.entity.Users;
import eco.sustainnshare.webapp.mappers.ItemsMapper;
import eco.sustainnshare.webapp.repository.CategoriesRepository;
import eco.sustainnshare.webapp.repository.ItemsRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;
    private final ItemsMapper itemsMapper;
    private final UsersRepository usersRepository;
    private final BadgeService badgeService;
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
        var sharedItems = getSharedItemsByUser(donor.getUserID());
        List<UserBadges> badges = new ArrayList<>();
        if (sharedItems.size() == 0){
            badges.add(UserBadges.builder()
                            .user(donor)
                            .badge(badgeService.getAdvocateBadge())
                            .dateIssued(new Date())
                    .build());
            badges.add(UserBadges.builder()
                            .user(donor)
                            .badge(badgeService.getFirstTimeBadge())
                            .dateIssued(new Date())
                    .build());
        }
        if (sharedItems.size() == 4){
            badges.add(UserBadges.builder()
                    .user(donor)
                    .badge(badgeService.getFifthTimeBadge())
                    .dateIssued(new Date())
                    .build());
        }
        if (sharedItems.size() == 9){
            badges.add(UserBadges.builder()
                    .user(donor)
                    .badge(badgeService.getTenthTimeBadge())
                    .dateIssued(new Date())
                    .build());
        }
        if (sharedItems.size() == 19){
            badges.add(UserBadges.builder()
                    .user(donor)
                    .badge(badgeService.getTwentiethTimeBadge())
                    .dateIssued(new Date())
                    .build());
        }
        Set<Integer> itemCategories = new HashSet<>();
        for (var sharedItem : getSharedItemsByUser(donor.getUserID())){
            itemCategories.add(sharedItem.getCategory());
            itemCategories.add(item.getCategory());
        }
        if(itemCategories.size() >= 4){
            var varietyBadge = donor.getBadges().stream().filter(s -> s.getBadge().getBadgeId() == 5).findAny();
            if (!varietyBadge.isPresent()){
                badges.add(UserBadges.builder()
                        .user(donor)
                        .badge(badgeService.getVarietyBadge())
                        .dateIssued(new Date())
                        .build());
            }
        }
        Items createdItem = itemsMapper.createdItemDtoToEntity(item);
        createdItem.setDonor(donor);
        createdItem.setGeoLocation(donor.getGeoLocation());
        itemsRepository.save(createdItem);
        donor.getBadges().addAll(badges);
        usersRepository.save(donor);
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
