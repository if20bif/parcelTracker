package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.mapstruct.Mapper;

@Mapper
public interface TruckMapper {
    Truck truckEntityToTruck(TruckEntity truckEntity);
    TruckEntity truckToTruckEntity(Truck truck);
}
