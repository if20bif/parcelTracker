package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class HopArrivalRepositoryTest {

    @Autowired
    HopArrivalRepository hopArrivalRepository;

    @Autowired
    ParcelRepository parcelRepository;

    @Autowired
    RecipientRepository recipientRepository;

    @Test
    void hopArrivalRepositoryTest(){

        RecipientEntity recipientEntity = new RecipientEntity(null, "John Doe", "Kärntnerstraße 1", "1010", "Vienna", "Austria");

        recipientRepository.save(recipientEntity);

        ParcelEntity parcelEntity = new ParcelEntity(null, "123456789", TrackingInformation.StateEnum.DELIVERED, new ArrayList<>(), new ArrayList<>(), 1.0f, recipientEntity, recipientEntity);

        parcelRepository.save(parcelEntity);

        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity(null, "123456789", "Description", OffsetDateTime.now(), parcelEntity);

        //Create
        hopArrivalRepository.save(hopArrivalEntity);

        assertEquals(1, hopArrivalRepository.count());

        //Read
        List<HopArrivalEntity> results = hopArrivalRepository.findByCode("123456789");

        assertEquals(1, results.size());

        //Update
        hopArrivalEntity = results.get(0);
        hopArrivalEntity.setCode("987654231");
        hopArrivalRepository.save(hopArrivalEntity);
        results = hopArrivalRepository.findByCode("987654231");

        assertEquals(1, results.size());

        //Delete
        hopArrivalRepository.delete(hopArrivalEntity);

        assertEquals(0, hopArrivalRepository.findAll().size());

        parcelRepository.delete(parcelEntity);

        recipientRepository.delete(recipientEntity);
    }
}