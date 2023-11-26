package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.dto.BlogPostCommentDto;
import eco.sustainnshare.webapp.entity.BlogComment;
import eco.sustainnshare.webapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostCommentRepository extends JpaRepository<BlogComment,Integer> {
    List<BlogComment> findAllByCommenter(Users commenter);
}
