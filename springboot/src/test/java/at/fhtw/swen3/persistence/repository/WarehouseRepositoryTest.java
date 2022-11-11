package at.fhtw.swen3.persistence.repository;

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
class WarehouseRepositoryTest {

    @Autowired
    WarehouseRepository repository;

    @Test
    void warehouseRepositoryTest(){
        WarehouseEntity warehouseEntity = new WarehouseEntity(null, 200, new ArrayList<>());

        //Save
        repository.save(warehouseEntity);
        assertEquals(1, repository.count());

        //Read
        List<WarehouseEntity> results = repository.findByLevel(200);
        assertEquals(1, results.size());

        //Update
        warehouseEntity = results.get(0);
        warehouseEntity.setLevel(100);
        repository.save(warehouseEntity);
        results = repository.findByLevel(100);

        assertEquals(1, results.size());

        //Delete
        repository.delete(warehouseEntity);
        assertEquals(0, repository.findAll().size());
    }

}