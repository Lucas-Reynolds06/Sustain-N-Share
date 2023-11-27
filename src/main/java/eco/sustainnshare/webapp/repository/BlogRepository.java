package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<BlogPost, Integer> {


    @Query(value = """
                    SELECT b FROM BlogPost b 
                    JOIN FETCH b.comments c 
                    JOIN FETCH c.commenter u
                    WHERE u.userID =  ?1""")
    List<BlogPost> findAllByCommentsUserId(int userId);

}
