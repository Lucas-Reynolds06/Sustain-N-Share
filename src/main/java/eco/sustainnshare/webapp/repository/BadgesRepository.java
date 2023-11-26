package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.Badges;
import eco.sustainnshare.webapp.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesRepository extends JpaRepository<Badges, Integer> {
}
