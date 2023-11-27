package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.Transactions;
import eco.sustainnshare.webapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    @Query(value = """
                    SELECT t FROM Transactions t 
                    JOIN FETCH t.receiver r
                    WHERE r.userID = ?1
                    AND t.status = 'Requested' 
                    """)
    List<Transactions> findAllByReceiver(int userID);
}
