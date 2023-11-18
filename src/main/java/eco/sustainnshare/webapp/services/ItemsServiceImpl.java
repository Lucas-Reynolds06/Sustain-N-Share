package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;
    @Override
    public Items getItemByID(int id) {
        var item = itemsRepository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        throw new RuntimeException("Item by ID " + id + " was not found");
    }
}
