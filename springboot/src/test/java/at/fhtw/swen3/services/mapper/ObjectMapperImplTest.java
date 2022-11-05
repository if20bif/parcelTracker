package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.*;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import static at.fhtw.swen3.services.dto.TrackingInformation.StateEnum.DELIVERED;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObjectMapperImplTest {

    private ObjectMapperImpl map;

    @BeforeAll
    public void setup(){
        map = new ObjectMapperImpl();
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
    void HopArrivalEntityToHopArrival() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();

        hopArrivalEntity.setCode("TEST1234");
        hopArrivalEntity.setDescription("Warehouse 12-27");
        hopArrivalEntity.setDateTime(OffsetDateTime.MIN);

        HopArrival hopArrival = map.hopArrivalEntityToHopArrival(hopArrivalEntity);

        assertTrue(hopArrival.getCode().equals("TEST1234"));
        assertTrue(hopArrival.getDescription().equals("Warehouse 12-27"));
        assertEquals(hopArrival.getDateTime(), OffsetDateTime.MIN);
    }

    @Test
    void geoCoordinateEntityToGeoCoordinate() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();

        geoCoordinateEntity.setLat(1.0);
        geoCoordinateEntity.setLon(1.0);

        GeoCoordinate geoCoordinate = map.geoCoordinateEntityToGeoCoordinate(geoCoordinateEntity);

        assertEquals(1.0, geoCoordinate.getLat());
        assertEquals(1.0, geoCoordinate.getLon());
    }

    @Test
    void geoCoordinateToGeoCoordinateEntity() {
        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat(1.0);
        geoCoordinate.setLon(1.0);

        GeoCoordinateEntity geoCoordinateEntity = map.geoCoordinateToGeoCoordinateEntity(geoCoordinate);

        assertEquals(1.0, geoCoordinateEntity.getLat());
        assertEquals(1.0, geoCoordinateEntity.getLon());
    }

    @Test
    void hopEntityToHop() {
        HopEntity hopEntity = new HopEntity();

        hopEntity.setHopType("TYPE");
        hopEntity.setLocationName("LOCATION");
        hopEntity.setDescription("DESC");
        hopEntity.setCode("CODE");
        hopEntity.setProcessingDelayMins(10);
        //hopEntity.setLocationCoordinates();

        Hop hop = map.hopEntityToHop(hopEntity);

        assertTrue(hop.getHopType().equals("TYPE"));
        assertTrue(hop.getLocationName().equals("LOCATION"));
        assertTrue(hop.getDescription().equals("DESC"));
        assertTrue(hop.getCode().equals(("CODE")));
        assertEquals(10, hop.getProcessingDelayMins());
        //assertNotNull(hop.getLocationCoordinates());
    }

    @Test
    void hopToHopEntity() {
        Hop hop = new Hop();

        hop.setHopType("TYPE");
        hop.setLocationName("LOCATION");
        hop.setDescription("DESC");
        hop.setCode("CODE");
        hop.setProcessingDelayMins(10);
        //hop.setLocationCoordinates(new GeoCoordinate());

        HopEntity hopEntity = map.hopToHopEntity(hop);

        assertTrue(hopEntity.getHopType().equals("TYPE"));
        assertTrue(hopEntity.getLocationName().equals("LOCATION"));
        assertTrue(hopEntity.getDescription().equals("DESC"));
        assertTrue(hopEntity.getCode().equals(("CODE")));
        assertEquals(10, hopEntity.getProcessingDelayMins());
        //assertNotNull(hopEntity.getLocationCoordinates());
    }

    @Test
    void transferWarehouseEntityToTransferWarehouse() {
        TransferWarehouseEntity transferWarehouseEntity = new TransferWarehouseEntity();

        transferWarehouseEntity.setLogisticsPartnerUrl("URL");
        transferWarehouseEntity.setRegionGeoJson("REGION");
        transferWarehouseEntity.setLogisticsPartner("PARTNER");

        TransferWarehouse transferWarehouse = map.transferWarehouseEntityToTransferWarehouse(transferWarehouseEntity);

        assertTrue(transferWarehouse.getLogisticsPartnerUrl().equals("URL"));
        assertTrue(transferWarehouse.getRegionGeoJson().equals("REGION"));
        assertTrue(transferWarehouse.getLogisticsPartner().equals("PARTNER"));
    }

    @Test
    void transferWarehouseToTransferWarehouseEntity() {
        TransferWarehouse transferWarehouse = new TransferWarehouse();

        transferWarehouse.setLogisticsPartnerUrl("URL");
        transferWarehouse.setRegionGeoJson("REGION");
        transferWarehouse.setLogisticsPartner("PARTNER");

        TransferWarehouseEntity transferWarehouseEntity = map.transferWarehouseToTransferWarehouseEntity(transferWarehouse);

        assertTrue(transferWarehouseEntity.getLogisticsPartnerUrl().equals("URL"));
        assertTrue(transferWarehouseEntity.getRegionGeoJson().equals("REGION"));
        assertTrue(transferWarehouseEntity.getLogisticsPartner().equals("PARTNER"));
    }

    @Test
    void truckEntityToTruck() {
        TruckEntity truckEntity = new TruckEntity();

        truckEntity.setNumberPlate("NUMBERPLATE");
        truckEntity.setRegionGeoJson("REGION");

        Truck truck = map.truckEntityToTruck(truckEntity);

        assertTrue(truck.getNumberPlate().equals("NUMBERPLATE"));
        assertTrue(truck.getRegionGeoJson().equals("REGION"));
    }

    @Test
    void truckToTruckEntity() {
        Truck truck = new Truck();

        truck.setNumberPlate("NUMBERPLATE");
        truck.setRegionGeoJson("REGION");

        TruckEntity truckEntity = map.truckToTruckEntity(truck);

        assertTrue(truckEntity.getNumberPlate().equals("NUMBERPLATE"));
        assertTrue(truckEntity.getRegionGeoJson().equals("REGION"));
    }

    @Test
    void warehouseEntityToWarehouse() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setLevel(10);
        warehouseEntity.setNextHops(new ArrayList<>());

        Warehouse warehouse = map.warehouseEntityToWarehouse(warehouseEntity);

        assertEquals(10, warehouse.getLevel());
        assertNotNull(warehouse.getNextHops());
    }

    @Test
    void warehouseToWarehouseEntity() {
        Warehouse warehouse = new Warehouse();

        warehouse.setLevel(10);
        warehouse.setNextHops(new ArrayList<>());

        WarehouseEntity warehouseEntity = map.warehouseToWarehouseEntity(warehouse);

        assertEquals(10, warehouseEntity.getLevel());
        assertNotNull(warehouseEntity.getNextHops());
    }

    @Test
    void warehouseNextHopsEntityToWarehouseNextHops(){
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();

        warehouseNextHopsEntity.setTravelTimeMinutes(10);
        warehouseNextHopsEntity.setHop(new HopEntity());

        WarehouseNextHops warehouseNextHops = map.warehouseNextHopsEntityToWarehouseNextHops(warehouseNextHopsEntity);

        assertEquals(10, warehouseNextHops.getTravelTimeMinutes());
        assertNotNull(warehouseNextHops.getHop());
    }

    @Test
    void warehouseNextHopsToWarehouseNextHopsEntity(){
        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setTravelTimeMinutes(10);
        warehouseNextHops.setHop(new Hop());

        WarehouseNextHopsEntity warehouseNextHopsEntity = map.warehouseNextHopsToWarehouseNextHopsEntity(warehouseNextHops);

        assertEquals(10, warehouseNextHopsEntity.getTravelTimeMinutes());
        assertNotNull(warehouseNextHopsEntity.getHop());
    }

}