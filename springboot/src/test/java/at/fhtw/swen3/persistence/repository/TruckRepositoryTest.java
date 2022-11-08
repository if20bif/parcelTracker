package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class TruckRepositoryTest {

    @Autowired
    TruckRepository repository;

    @Test
    void truckRepositoryTest(){
        TruckEntity truckEntity = new TruckEntity(null, "{\"x\": 20.152, \"y\": 561.215}", "W234562");

        //Create
        repository.save(truckEntity);
        assertEquals(1, repository.count());

        //Read
        List<TruckEntity> results = repository.findByNumberPlate("W234562");
        assertEquals(1, results.size());

        //Update
        truckEntity = results.get(0);
        truckEntity.setNumberPlate("W111111");
        repository.save(truckEntity);
        results = repository.findByNumberPlate("W111111");

        assertEquals(1, results.size());

        //Delete
        repository.delete(truckEntity);
        assertEquals(0, repository.findAll().size());
    }
}