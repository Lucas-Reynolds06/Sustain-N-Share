package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoriesService {
    List<Categories> getAllCategories();
}
