package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferWarehouseRepository extends JpaRepository<TransferWarehouseEntity, Long> {
    List<TransferWarehouseEntity> findByLogisticsPartner(String logisticsPartner);
}
