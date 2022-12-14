package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class WarehouseNextHopsRepositoryTest {

    @Autowired
    WarehouseNextHopsRepository warehouseNextHopsRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    HopRepository hopRepository;

    @Test
    void recipientRepositoryTest(){

        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coords = new Coordinate(16.333361758251698, 48.23603769206206);
        Point point = geometryFactory.createPoint(coords);

        HopEntity hopEntity = new HopEntity(null, "HopType", "ACVD1234", "Description", 10, "Austria", point);

        hopRepository.save(hopEntity);

        WarehouseEntity warehouseEntity = new WarehouseEntity(200, new ArrayList<>());

        warehouseRepository.save(warehouseEntity);

        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity(null, 180, hopEntity, warehouseEntity);

        //Create
        warehouseNextHopsRepository.save(warehouseNextHopsEntity);
        assertEquals(1, warehouseNextHopsRepository.count());

        //Read
        List<WarehouseNextHopsEntity> results = warehouseNextHopsRepository.findByTravelTimeMinutes(180);
        assertEquals(1, results.size());

        //Update
        warehouseNextHopsEntity = results.get(0);
        warehouseNextHopsEntity.setTravelTimeMinutes(240);
        warehouseNextHopsRepository.save(warehouseNextHopsEntity);
        results = warehouseNextHopsRepository.findByTravelTimeMinutes(240);

        assertEquals(1, results.size());

        //Delete
        warehouseNextHopsRepository.delete(warehouseNextHopsEntity);
        assertEquals(0, warehouseNextHopsRepository.findAll().size());

        warehouseRepository.delete(warehouseEntity);

        hopRepository.delete(hopEntity);
    }
}