package eco.sustainnshare.webapp.repository;

import eco.sustainnshare.webapp.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    @Query(value = """
                    SELECT t FROM Transactions t
                    JOIN FETCH t.donor d 
                    WHERE d.userID =  ?1""")
    List<Transactions> getByDonorId(int donorId);

    @Query(value = """
                    SELECT t FROM Transactions t
                    JOIN FETCH t.receiver r 
                    WHERE r.userID =  ?1""")
    List<Transactions> getByReceiverId(int donorId);

    @Query(value = """
                    SELECT t FROM Transactions t
                    JOIN FETCH t.item i 
                    WHERE i.itemID =  ?1""")
    Transactions getByItemId(int itemId);
}
