package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {
    List<WarehouseEntity> findByLevel(Integer level);

    List<WarehouseEntity> findByCode(String code);
}
