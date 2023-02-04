package v2.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.CardV2;
import v2.domain.Orders;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardV2, Integer> {
    List<CardV2> findByIdOtv (Integer id);
    List<CardV2> findByDateCreate(Date date);

}
