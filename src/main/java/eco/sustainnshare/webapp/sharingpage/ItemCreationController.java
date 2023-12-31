package eco.sustainnshare.webapp.sharingpage;

import eco.sustainnshare.webapp.dto.CategoryDto;
import eco.sustainnshare.webapp.dto.ConditionDto;
import eco.sustainnshare.webapp.dto.CreateItemDto;
import eco.sustainnshare.webapp.dto.UserDto;
import eco.sustainnshare.webapp.entity.Categories;
import eco.sustainnshare.webapp.entity.Conditions;
import eco.sustainnshare.webapp.services.CategoriesService;
import eco.sustainnshare.webapp.services.ConditionsService;
import eco.sustainnshare.webapp.services.ItemsService;
import eco.sustainnshare.webapp.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemCreationController {
    private final CategoriesService categoriesService;
    private final ConditionsService conditionsService;
    private final ItemsService itemsService;

    @GetMapping("/create-item")
    public String createItem(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var authenticated = userDetails != null;
        model.addAttribute("isAuthenticated", authenticated);
        model.addAttribute("currentRoute", "create-item");
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
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("conditions",conditionDtos);
        return "create-form";
    }

    @PostMapping("/create-item")
    public String saveItem(@RequestParam("itemName") String name,
                           @RequestParam("description") String description,
                           @RequestParam("itemImage") MultipartFile multipartFile,
                           @RequestParam("category") Integer category,
                           @RequestParam("condition") Integer condition,
                           RedirectAttributes redirectAttributes) throws IOException {
        CreateItemDto item = new CreateItemDto();
        item.setItemName(name);
        item.setDescription(description);
        item.setCondition(condition);
        item.setCategory(category);
        String itemImage = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        item.setItemImage(itemImage);
        item.setDateListed(new Date());
        var savedItem = itemsService.saveCreatedItem(item);
        String itemDirectory = String.format("item-images/%d",savedItem.getItemID());
        FileUploadUtil.saveFile(itemDirectory,itemImage,multipartFile);
        redirectAttributes.addFlashAttribute("creationSuccess", "Item Shared!");
        return "redirect:/profile";
    }
}
