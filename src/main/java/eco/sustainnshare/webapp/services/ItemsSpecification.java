package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Items;
import eco.sustainnshare.webapp.entity.Locations;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class ItemsSpecification {


    public static Specification<Items> hasSearchText(String searchText){
        return ((root, query, criteriaBuilder) -> {
            if (searchText == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("name"),searchText);
        });
    }
    public static Specification<Items> hasCategory(Integer category){
        return ((root, query, criteriaBuilder) -> {
            if (category == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.join("category").get("categoryID"),category);
        });
    }
    public static Specification<Items> hasLocation(Locations location){
        return ((root, query, criteriaBuilder) -> {
            if (location == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("location"),location);
        });
    }
    public static Specification<Items> hasCondition(Integer condition){
        return ((root, query, criteriaBuilder) -> {
            if (condition == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.join("condition").get("conditionID"),condition);
        });
    }
    public static Specification<Items> hasTimeOnSite(Date timeOnSite){
        return ((root, query, criteriaBuilder) -> {
            if (timeOnSite == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("dateListed"),timeOnSite);
        });
    }
}
