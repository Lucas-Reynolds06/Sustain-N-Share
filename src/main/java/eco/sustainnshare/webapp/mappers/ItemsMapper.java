package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.DonorDto;
import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.repository.CategoriesRepository;
import eco.sustainnshare.webapp.repository.ConditionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemsMapper {
    private final CategoriesRepository categoriesRepository;
    private final ConditionsRepository conditionsRepository;

    public Items createdItemDtoToEntity(CreateItemDto item){
        return Items.builder()
                .itemImage(item.getItemImage())
                .category(categoriesRepository.findById(item.getCategory()).get())
                .condition(conditionsRepository.findById(item.getCondition()).get())
                .dateListed(item.getDateListed())
                .name(item.getItemName())
                .description(item.getDescription())
                .build();
    }
    public ItemDto itemEntityToDto(Items item){
        var donor = DonorDto.builder()
                .donorID(item.getDonor().getUserID())
                .screenName(item.getDonor().getScreenName())
                .avatarLocation(item.getDonor().getAvatar().getLocation())
                .build();
        return ItemDto.builder()
                .itemID(item.getItemID())
                .itemImage(item.getItemImage())
                .donor(donor)
                .category(item.getCategory().getCategoryID())
                .condition(item.getCondition().getConditionID())
                .dateListed(item.getDateListed())
                .description(item.getDescription())
                .location(item.getDonor().getCity())
                .name(item.getName())
                .build();
    }

    public List<ItemDto> itemEntitiesToDtos(List<Items> itemsList) {
        return itemsList.stream()
                .map(this::itemEntityToDto)
                .toList();
    }
}
