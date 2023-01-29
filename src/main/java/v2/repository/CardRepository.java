package v2.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v2.domain.CardV2;
@Repository
public interface CardRepository extends JpaRepository<CardV2, Integer> {

}
