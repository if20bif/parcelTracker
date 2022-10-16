package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import static at.fhtw.swen3.services.dto.TrackingInformation.StateEnum.DELIVERED;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParcelMapStructTest {

    private ParcelMapStruct map;

    @BeforeAll
    public void setup(){
        map = new ParcelMapStruct();
    }

    @Test
    void parcelEntityToTrackingInformation() {
        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setState(DELIVERED);
        parcelEntity.setVisitedHops(new ArrayList<>());
        parcelEntity.setFutureHops(new ArrayList<>());

        TrackingInformation trackingInformation = map.parcelEntityToTrackingInformation(parcelEntity);

        assertEquals(DELIVERED, trackingInformation.getState());
        assertNotNull(trackingInformation.getVisitedHops());
        assertNotNull(trackingInformation.getFutureHops());
    }

    @Test
    void trackingInformationToParcelEntity() {
        TrackingInformation trackingInformation = new TrackingInformation();

        trackingInformation.setState(DELIVERED);
        trackingInformation.setVisitedHops(new ArrayList<>());
        trackingInformation.setFutureHops(new ArrayList<>());

        ParcelEntity parcelEntity = map.trackingInformationToParcelEntity(trackingInformation);

        assertEquals(DELIVERED, parcelEntity.getState());
        assertNotNull(parcelEntity.getVisitedHops());
        assertNotNull(parcelEntity.getFutureHops());
    }

    @Test
    void parcelEntityToNewParcelInfo() {
        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setTrackingId("123456789");

        NewParcelInfo newParcelInfo = map.parcelEntityToNewParcelInfo(parcelEntity);

        assertTrue(newParcelInfo.getTrackingId().equals("123456789"));
    }

    @Test
    void newParcelInfoToParcelEntity() {
        NewParcelInfo newParcelInfo = new NewParcelInfo();

        newParcelInfo.setTrackingId("123456789");

        ParcelEntity parcelEntity = map.newParcelInfoToParcelEntity(newParcelInfo);

        assertTrue(parcelEntity.getTrackingId().contains("123456789"));
    }

    @Test
    void parcelEntityToParcel() {
        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setWeight(1.0f);

        Parcel parcel = map.parcelEntityToParcel(parcelEntity);

        assertEquals(1.0f, parcel.getWeight());
    }

    @Test
    void parcelToParcelEntity() {
        Parcel parcel = new Parcel();

        parcel.setWeight(1.0f);

        ParcelEntity parcelEntity = map.parcelToParcelEntity(parcel);

        assertEquals(1.0f, parcelEntity.getWeight());
    }

    @Test
    void recipientEntityToRecipient() {
        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setName("John Doe");
        recipientEntity.setStreet("Hoechstaedtplatz 6");
        recipientEntity.setPostalCode("A-1200");
        recipientEntity.setCity("Vienna");
        recipientEntity.setCountry("Austria");

        Recipient recipient = map.recipientEntityToRecipient(recipientEntity);

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

        RecipientEntity recipientEntity = map.recipientToRecipientEntity(recipient);

        assertTrue(recipientEntity.getName().equals("John Doe"));
        assertTrue(recipientEntity.getStreet().equals("Hoechstaedtplatz 6"));
        assertTrue(recipientEntity.getPostalCode().equals("A-1200"));
        assertTrue(recipientEntity.getCity().equals("Vienna"));
        assertTrue(recipientEntity.getCountry().equals("Austria"));
    }

    @Test
    void hopArrivalToHopArrivalEntity() {
        HopArrival hopArrival = new HopArrival();

        hopArrival.setCode("TEST1234");
        hopArrival.setDescription("Warehouse 12-27");
        hopArrival.setDateTime(OffsetDateTime.MIN);

        HopArrivalEntity hopArrivalEntity = map.hopArrivalToHopArrivalEntity(hopArrival);

        assertTrue(hopArrivalEntity.getCode().equals("TEST1234"));
        assertTrue(hopArrivalEntity.getDescription().equals("Warehouse 12-27"));
        assertEquals(hopArrivalEntity.getDateTime(), OffsetDateTime.MIN);
    }

    @Test
    void testHopArrivalToHopArrivalEntity() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();

        hopArrivalEntity.setCode("TEST1234");
        hopArrivalEntity.setDescription("Warehouse 12-27");
        hopArrivalEntity.setDateTime(OffsetDateTime.MIN);

        HopArrival hopArrival = map.hopArrivalEntityToHopArrival(hopArrivalEntity);

        assertTrue(hopArrival.getCode().equals("TEST1234"));
        assertTrue(hopArrival.getDescription().equals("Warehouse 12-27"));
        assertEquals(hopArrival.getDateTime(), OffsetDateTime.MIN);
    }
}