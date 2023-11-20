package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogPost, Integer> {
}
