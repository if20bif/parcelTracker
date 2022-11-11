package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HopArrivalRepository extends JpaRepository<HopArrivalEntity, Long> {

    List<HopArrivalEntity> findByCode(String code);

}
