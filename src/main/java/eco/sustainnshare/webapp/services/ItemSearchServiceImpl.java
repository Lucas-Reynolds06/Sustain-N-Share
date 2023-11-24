package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.SearchItemDto;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ItemSearchServiceImpl implements ItemSearchService {
    private final ItemsRepository itemsRepository;
    @Override
    public List<Items> searchItems(SearchItemDto searchItems) {
        var specification = Specification
                .where(ItemsSpecification.hasSearchText(searchItems.getSearchText()))
                .and(ItemsSpecification.hasCategory(searchItems.getCategory()))
                .and(ItemsSpecification.hasCondition(searchItems.getCondition()))
                .and(ItemsSpecification.hasGeoLocation(null))
                .and(ItemsSpecification.hasTimeOnSite(searchItems.getTimeOnSite()));
                .and(ItemsSpecification.hasGeoLocation(null));
        return itemsRepository.findAll(specification);
    }
}
