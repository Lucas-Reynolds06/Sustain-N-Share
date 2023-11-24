package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Integer> {
    Avatar findAvatarByLocation(String location);
}
