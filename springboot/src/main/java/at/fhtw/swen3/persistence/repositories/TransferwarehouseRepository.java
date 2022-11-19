package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Long> {
    List<TransferwarehouseEntity> findByLogisticsPartner(String logisticsPartner);
}
