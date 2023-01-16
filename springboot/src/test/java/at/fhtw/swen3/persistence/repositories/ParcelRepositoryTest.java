package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class ParcelRepositoryTest {

    @Autowired
    ParcelRepository parcelRepository;

    @Autowired
    RecipientRepository recipientRepository;

    @Test
    void parcelRepositoryTest(){

        RecipientEntity recipientEntity = new RecipientEntity(null, "John Doe", "Kaerntnerstraße 1", "A-1010", "Vienna", "Austria", null);

        ParcelEntity parcelEntity = new ParcelEntity(null, "123456789", TrackingInformation.StateEnum.DELIVERED, new ArrayList<>(), new ArrayList<>(), 1.0f, recipientEntity, recipientEntity);

        //Create
        parcelRepository.save(parcelEntity);

        assertEquals(1, parcelRepository.count());

        //Read
        List<ParcelEntity> results = parcelRepository.findByTrackingId("123456789");

        assertEquals(1, results.size());

        //Update
        parcelEntity = results.get(0);
        parcelEntity.setTrackingId("987654231");
        parcelRepository.save(parcelEntity);
        results = parcelRepository.findByTrackingId("987654231");

        assertEquals(1, results.size());

        //Delete
        parcelRepository.delete(parcelEntity);

        assertEquals(0, parcelRepository.findAll().size());

        recipientRepository.delete(recipientEntity);
    }
}