package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class RecipientRepositoryTest {

    @Autowired
    RecipientRepository repository;

    @Test
    void recipientRepositoryTest(){

        RecipientEntity recipientEntity = new RecipientEntity(null, "John Doe", "Kaerntnerstraße 1", "A-1010", "Vienna", "Austria", null);

        //Create
        repository.save(recipientEntity);
        assertEquals(1, repository.count());

        //Read
        List<RecipientEntity> results = repository.findByName("John Doe");
        assertEquals(1, results.size());

        //Update
        recipientEntity = results.get(0);
        recipientEntity.setName("Jane Doe");
        repository.save(recipientEntity);
        results = repository.findByName("Jane Doe");

        assertEquals(1, results.size());

        //Delete
        repository.delete(recipientEntity);
        assertEquals(0, repository.findAll().size());
    }
}
