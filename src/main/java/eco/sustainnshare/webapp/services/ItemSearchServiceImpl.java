package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.dto.ItemDto;
import eco.sustainnshare.webapp.dto.SearchItemDto;
import eco.sustainnshare.webapp.dto.TransactionDto;
import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.mappers.ItemsMapper;
import eco.sustainnshare.webapp.mappers.TransactionsMapper;
import eco.sustainnshare.webapp.repository.ItemsRepository;
import eco.sustainnshare.webapp.repository.TransactionsRepository;
import eco.sustainnshare.webapp.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ItemSearchServiceImpl implements ItemSearchService {
    private final ItemsRepository itemsRepository;
    private final ItemsMapper itemsMapper;
    private final TransactionsMapper transactionsMapper;
    private final TransactionsRepository transactionsRepository;
    @Override
    public List<ItemDto> searchItems(SearchItemDto searchItems) {
        var specification = Specification
                .where(ItemsSpecification.hasSearchText(searchItems.getSearchText()))
                .and(ItemsSpecification.hasCategory(searchItems.getCategory()))
                .and(ItemsSpecification.hasCondition(searchItems.getCondition()))
                .and(ItemsSpecification.hasGeoLocation(null));
        return itemsMapper.itemEntitiesToDtos(itemsRepository.findAll(specification));
    }

    @Override
    public ItemDto getItem(Integer id) {
        return itemsMapper.itemEntityToDto(itemsRepository.findById(id).get());
    }
    @Override
    public TransactionDto requestItem(Integer user, Integer itemID){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setItemID(itemID);
        transactionDto.setDonorID(itemsRepository.getReferenceById(itemID).getDonor().getUserID());
        transactionDto.setReceiverID(user);
        transactionDto.setStatus("Requested");
        transactionDto.setDateInitiated(new Date());
        transactionDto.setDateCompleted(null);
        transactionsRepository.save(transactionsMapper.transactionDtoToEntity(transactionDto));
        return transactionDto;
    }
}
