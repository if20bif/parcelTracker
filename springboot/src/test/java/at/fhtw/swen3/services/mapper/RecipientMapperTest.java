package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecipientMapperTest {

    private RecipientMapperImpl  mapper;

    @BeforeAll
    public void setup(){
        mapper = new RecipientMapperImpl();
    }

    @Test
    void recipientEntityToRecipient() {
        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setName("John Doe");
        recipientEntity.setStreet("Hoechstaedtplatz 6");
        recipientEntity.setPostalCode("A-1200");
        recipientEntity.setCity("Vienna");
        recipientEntity.setCountry("Austria");

        Recipient recipient = mapper.recipientEntityToRecipient(recipientEntity);

        assertTrue(recipient.getName().equals("John Doe"));
        assertTrue(recipient.getStreet().equals("Hoechstaedtplatz 6"));
        assertTrue(recipient.getPostalCode().equals("A-1200"));
        assertTrue(recipient.getCity().equals("Vienna"));
        assertTrue(recipient.getCountry().equals("Austria"));
    }

    @Test
    void recipientToRecipientEntity() {
        Recipient recipient = new Recipient();

        recipient.setName("John Doe");
        recipient.setStreet("Hoechstaedtplatz 6");
        recipient.setPostalCode("A-1200");
        recipient.setCity("Vienna");
        recipient.setCountry("Austria");

        RecipientEntity recipientEntity = mapper.recipientToRecipientEntity(recipient);

        assertTrue(recipientEntity.getName().equals("John Doe"));
        assertTrue(recipientEntity.getStreet().equals("Hoechstaedtplatz 6"));
        assertTrue(recipientEntity.getPostalCode().equals("A-1200"));
        assertTrue(recipientEntity.getCity().equals("Vienna"));
        assertTrue(recipientEntity.getCountry().equals("Austria"));
    }
}