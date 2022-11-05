package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entity.TransferWarehouseEntity;
import at.fhtw.swen3.persistence.entity.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckRepository extends JpaRepository<TruckEntity, Long> {
    List<TruckEntity> findByNumberPlate(String numberPlate);
}
