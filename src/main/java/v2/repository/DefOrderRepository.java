package v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.NSIDefOrders;
import v2.domain.Orders;

@Repository
public interface DefOrderRepository extends JpaRepository<NSIDefOrders, Integer> {
}
