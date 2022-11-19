package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class TransferwarehouseRepositoryTest {

    @Autowired
    TransferwarehouseRepository repository;

    @Test
    void transferWarehouseRepositoryTest(){
        TransferwarehouseEntity transferWarehouseEntity = new TransferwarehouseEntity(null, "{\"x\": 20.152, \"y\": 561.215}", "ABC AG", "www.abcAG.com");

        //Create
        repository.save(transferWarehouseEntity);
        assertEquals(1, repository.count());

        //Read
        List<TransferwarehouseEntity> results = repository.findByLogisticsPartner("ABC AG");
        assertEquals(1, results.size());

        //Update
        transferWarehouseEntity = results.get(0);
        transferWarehouseEntity.setLogisticsPartner("UFF GMBH");
        repository.save(transferWarehouseEntity);
        results = repository.findByLogisticsPartner("UFF GMBH");

        assertEquals(1, results.size());

        //Delete
        repository.delete(transferWarehouseEntity);
        assertEquals(0, repository.findAll().size());
    }
}