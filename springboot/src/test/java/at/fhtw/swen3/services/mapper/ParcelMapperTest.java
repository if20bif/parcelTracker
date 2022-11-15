package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static at.fhtw.swen3.services.dto.TrackingInformation.StateEnum.DELIVERED;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParcelMapperTest {

    private ParcelMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new ParcelMapperImpl();
    }

    @Test
    void parcelEntityToParcel() {
        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setWeight(1.0f);

        Parcel parcel = mapper.parcelEntityToParcel(parcelEntity);

        assertEquals(1.0f, parcel.getWeight());
    }

    @Test
    void parcelToParcelEntity() {
        Parcel parcel = new Parcel();

        parcel.setWeight(1.0f);

        ParcelEntity parcelEntity = mapper.parcelToParcelEntity(parcel);

        assertEquals(1.0f, parcelEntity.getWeight());
    }

    @Test
    void parcelEntityToNewParcelInfo() {
        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setTrackingId("123456789");

        NewParcelInfo newParcelInfo = mapper.parcelEntityToNewParcelInfo(parcelEntity);

        assertTrue(newParcelInfo.getTrackingId().equals("123456789"));
    }

    @Test
    void newParcelInfoToParcelEntity() {
        NewParcelInfo newParcelInfo = new NewParcelInfo();

        newParcelInfo.setTrackingId("123456789");

        ParcelEntity parcelEntity = mapper.newParcelInfoToParcelEntity(newParcelInfo);

        assertTrue(parcelEntity.getTrackingId().contains("123456789"));
    }

    @Test
    void parcelEntityToTrackingInformation() {
        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setState(DELIVERED);
        parcelEntity.setVisitedHops(new ArrayList<>());
        parcelEntity.setFutureHops(new ArrayList<>());

        TrackingInformation trackingInformation = mapper.parcelEntityToTrackingInformation(parcelEntity);

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

        ParcelEntity parcelEntity = mapper.trackingInformationToParcelEntity(trackingInformation);

        assertEquals(DELIVERED, parcelEntity.getState());
        assertNotNull(parcelEntity.getVisitedHops());
        assertNotNull(parcelEntity.getFutureHops());
    }
}