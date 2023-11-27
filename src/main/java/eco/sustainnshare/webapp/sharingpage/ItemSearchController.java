package eco.sustainnshare.webapp.sharingpage;

import eco.sustainnshare.webapp.dto.*;
import eco.sustainnshare.webapp.entity.Categories;
import eco.sustainnshare.webapp.entity.Conditions;
import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemSearchController {
    private final ItemSearchService itemSearchService;
    private final CategoriesService categoriesService;
    private final ConditionsService conditionsService;
    private final StateService stateService;
    private final UsersService userService;

    @GetMapping("/search-items")
    public String searchItems(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "search-items");
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
        List<StateDto> stateDtos = stateService.getStates();
        model.addAttribute("items",searchItems);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("conditions",conditionDtos);
        model.addAttribute("states",stateDtos);
        model.addAttribute("isAuthenticated", authenticated);
        return "search-form";
    }

    @PostMapping ("/search-items")
    public String searchItems(Model model, SearchItemDto searchItems){
        List<ItemDto> items = itemSearchService.searchItems(searchItems);
        model.addAttribute("items",items);
        return "items";
    }

    @GetMapping("/item/{id}")
    public String searchItems(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") Integer id, Model model){
        var authenticated = userDetails != null;
        model.addAttribute("currentRoute", "search-items");
        model.addAttribute("isAuthenticated", authenticated);
        var item = itemSearchService.getItem(id);
        model.addAttribute("item", item);
        return "item";
    }
    @PostMapping("/item-request/{id}")
    public String requestItem(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") Integer id, Model model){
        var user = userService.getUserByUsername(userDetails.getUsername());
        model.addAttribute("currentRoute","item-request");
        itemSearchService.requestItem(user.getUserID(), id);
        return "redirect:/profile";
    }
}
