package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.Conditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionsRepository extends JpaRepository<Conditions, Integer> {
}
