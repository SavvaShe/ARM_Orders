package v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import v2.domain.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
