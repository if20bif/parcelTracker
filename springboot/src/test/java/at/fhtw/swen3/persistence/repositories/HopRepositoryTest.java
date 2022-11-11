package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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

        HopEntity hopEntity = new HopEntity(null, "HopType", "123456789", "Description", 10, "Austria", null);

        WarehouseEntity warehouseEntity = new WarehouseEntity(null, 200, new ArrayList<>());

        //Create
        repository.save(hopEntity);
        assertEquals(1, repository.count());

        //Read
        List<HopEntity> results = repository.findByCode("123456789");
        assertEquals(1, results.size());

        //Update
        hopEntity = results.get(0);
        hopEntity.setCode("987654321");
        repository.save(hopEntity);
        results = repository.findByCode("987654321");

        assertEquals(1, results.size());

        //Delete
        repository.delete(hopEntity);
        assertEquals(0, repository.findAll().size());
    }
}