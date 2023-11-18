package eco.sustainnshare.webapp.sharingpage;

import eco.sustainnshare.webapp.dto.CategoryDto;
import eco.sustainnshare.webapp.dto.ConditionDto;
import eco.sustainnshare.webapp.dto.SearchItemDto;
import eco.sustainnshare.webapp.entity.Categories;
import eco.sustainnshare.webapp.entity.Conditions;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.repository.CategoriesRepository;
import eco.sustainnshare.webapp.services.CategoriesService;
import eco.sustainnshare.webapp.services.ConditionsService;
import eco.sustainnshare.webapp.services.ItemSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemSearchService itemSearchService;
    private final CategoriesService categoriesService;
    private final ConditionsService conditionsService;

    @GetMapping("/search-items")
    public String searchItems(Model model) {
        SearchItemDto searchItems = new SearchItemDto();
        List<Categories> categories = categoriesService.getAllCategories();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (var category: categories){
            categoryDtos.add(CategoryDto.builder()
                            .categoryID(category.getCategoryID())
                            .name(category.getName())
                    .build());
        }
        List<Conditions> conditions = conditionsService.getAllConditions();
        List<ConditionDto> conditionDtos = new ArrayList<>();
        for(var condition: conditions){
            conditionDtos.add(ConditionDto.builder()
                            .id(condition.getConditionID())
                            .name(condition.getName())
                    .build());
        }
        model.addAttribute("items",searchItems);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("conditions",conditionDtos);
        return "search-form";
    }

    @PostMapping ("/search-items")
    public String searchItems(Model model, SearchItemDto searchItems){
        List<Items> items = itemSearchService.searchItems(searchItems);
        model.addAttribute("items",items);
        return "items";
    }
}
