package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.States;
import eco.sustainnshare.webapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;

@Repository
public interface StatesRepository extends JpaRepository<States,Integer> {

    States findStateByName(String name);
}
