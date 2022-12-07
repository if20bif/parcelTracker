package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
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
class HopRepositoryTest {

    @Autowired
    HopRepository repository;

    @Test
    void hopRepositoryTest(){

        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coords = new Coordinate(16.333361758251698, 48.23603769206206);
        Point point = geometryFactory.createPoint(coords);

        HopEntity hopEntity = new HopEntity(null, "HopType", "ACVD1234", "Description", 10, "Austria", point);

        WarehouseEntity warehouseEntity = new WarehouseEntity(200, new ArrayList<>());

        //Create
        repository.save(hopEntity);
        assertEquals(1, repository.count());

        //Read
        List<HopEntity> results = repository.findByCode("ACVD1234");
        //System.out.println(results.get(0).getLocationCoordinates().getX());
        //System.out.println(results.get(0).getLocationCoordinates().getY());
        assertEquals(1, results.size());

        //Update
        hopEntity = results.get(0);
        hopEntity.setCode("ACVD1235");
        repository.save(hopEntity);
        results = repository.findByCode("ACVD1235");

        assertEquals(1, results.size());

        //Delete
        repository.delete(hopEntity);
        assertEquals(0, repository.findAll().size());
    }
}