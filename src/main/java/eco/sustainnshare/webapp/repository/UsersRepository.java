package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findUsersByUsername(String username);

    Users findUsersByEmail(String email);
    @Query("SELECT u FROM Users u Where u.username = ?#{principal.username}")
    Optional<Users> findLoginUser();
}
