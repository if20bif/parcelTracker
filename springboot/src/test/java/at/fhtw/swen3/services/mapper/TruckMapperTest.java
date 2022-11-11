package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TruckMapperTest {

    private TruckMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new TruckMapperImpl();
    }

    @Test
    void truckEntityToTruck() {
        TruckEntity truckEntity = new TruckEntity();

        truckEntity.setNumberPlate("NUMBERPLATE");
        truckEntity.setRegionGeoJson("REGION");

        Truck truck = mapper.truckEntityToTruck(truckEntity);

        assertTrue(truck.getNumberPlate().equals("NUMBERPLATE"));
        assertTrue(truck.getRegionGeoJson().equals("REGION"));
    }

    @Test
    void truckToTruckEntity() {
        Truck truck = new Truck();

        truck.setNumberPlate("NUMBERPLATE");
        truck.setRegionGeoJson("REGION");

        TruckEntity truckEntity = mapper.truckToTruckEntity(truck);

        assertTrue(truckEntity.getNumberPlate().equals("NUMBERPLATE"));
        assertTrue(truckEntity.getRegionGeoJson().equals("REGION"));
    }
}