package eco.sustainnshare.webapp.services;

import eco.sustainnshare.webapp.entity.Items;
import jakarta.persistence.criteria.Predicate;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class ItemsSpecification {


    public static Specification<Items> hasSearchText(String searchText){
        return ((root, query, criteriaBuilder) -> {
            if (searchText == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            String[] keywords = searchText.split(" ");
            Predicate predicate = criteriaBuilder.conjunction();
            for (String keyword : keywords){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%" + keyword.toLowerCase() + "%"));
            }
            return predicate;
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
    public static Specification<Items> hasGeoLocation(Point location){
        return ((root, query, criteriaBuilder) -> {
            if (location == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.equal(root.get("geoLocation"),location);
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
}
