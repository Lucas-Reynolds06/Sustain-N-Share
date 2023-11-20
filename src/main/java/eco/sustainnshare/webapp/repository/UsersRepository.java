package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findUsersByUsername(String username);

    Users findUsersByEmail(String email);
}
