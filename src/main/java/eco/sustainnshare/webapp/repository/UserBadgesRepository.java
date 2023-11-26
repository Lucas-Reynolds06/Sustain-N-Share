package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.UserBadges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBadgesRepository extends JpaRepository<UserBadges, Integer> {
}
