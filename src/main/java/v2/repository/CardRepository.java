package v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import v2.domain.CardV2;

public interface CardRepository extends JpaRepository<CardV2, Integer> {
}
