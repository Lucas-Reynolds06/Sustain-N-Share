package eco.sustainnshare.webapp.mappers;

import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.repository.CategoriesRepository;
import eco.sustainnshare.webapp.repository.ConditionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
        return ItemDto.builder()
                .itemID(item.getItemID())
                .itemImage(item.getItemImage())
                .donor(item.getDonor().getScreenName())
                .category(item.getCategory().getCategoryID())
                .condition(item.getCondition().getConditionID())
                .dateListed(item.getDateListed())
                .description(item.getDescription())
                .location(item.getDonor().getCity())
                .name(item.getName())
                .build();
    }
}
