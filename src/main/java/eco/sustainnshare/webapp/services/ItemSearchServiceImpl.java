package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.dto.SearchItemDto;
import eco.sustainnshare.webapp.mappers.ItemsMapper;
import eco.sustainnshare.webapp.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ItemSearchServiceImpl implements ItemSearchService {
    private final ItemsRepository itemsRepository;
    private final ItemsMapper itemsMapper;
    @Override
    public List<ItemDto> searchItems(SearchItemDto searchItems) {
        var specification = Specification
                .where(ItemsSpecification.hasSearchText(searchItems.getSearchText()))
                .and(ItemsSpecification.hasCategory(searchItems.getCategory()))
                .and(ItemsSpecification.hasCondition(searchItems.getCondition()))
                .and(ItemsSpecification.hasGeoLocation(null));
        return itemsMapper.itemEntitiesToDtos(itemsRepository.findAll(specification));
    }
}
