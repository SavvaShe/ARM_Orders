package v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.Orders;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByIdCard (Integer idCard);
    List<Orders> findByIdOtv (Integer id);
    List<Orders> findByDateCreate(Date date);

}
