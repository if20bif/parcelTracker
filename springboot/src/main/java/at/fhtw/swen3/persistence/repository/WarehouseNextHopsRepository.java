package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Long> {

    List<WarehouseNextHopsEntity> findByTravelTimeMinutes(int travelTimeMinutes);

}
