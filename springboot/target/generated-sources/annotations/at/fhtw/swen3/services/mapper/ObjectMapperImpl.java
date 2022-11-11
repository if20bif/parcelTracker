package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity.HopArrivalEntityBuilder;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity.TransferWarehouseEntityBuilder;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.HopArrival.HopArrivalBuilder;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.NewParcelInfo.NewParcelInfoBuilder;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Parcel.ParcelBuilder;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.Recipient.RecipientBuilder;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.dto.TrackingInformation.TrackingInformationBuilder;
import at.fhtw.swen3.services.dto.TransferWarehouse;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-08T15:18:12+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ObjectMapperImpl implements ObjectMapper {

    @Override
    public TrackingInformation parcelEntityToTrackingInformation(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        TrackingInformationBuilder trackingInformation = TrackingInformation.builder();

        trackingInformation.state( parcelEntity.getState() );
        trackingInformation.visitedHops( hopArrivalEntityListToHopArrivalList( parcelEntity.getVisitedHops() ) );
        trackingInformation.futureHops( hopArrivalEntityListToHopArrivalList( parcelEntity.getFutureHops() ) );

        return trackingInformation.build();
    }

    @Override
    public ParcelEntity trackingInformationToParcelEntity(TrackingInformation trackingInformation) {
        if ( trackingInformation == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.state( trackingInformation.getState() );
        parcelEntity.visitedHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getVisitedHops() ) );
        parcelEntity.futureHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getFutureHops() ) );

        return parcelEntity.build();
    }

    @Override
    public NewParcelInfo parcelEntityToNewParcelInfo(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        NewParcelInfoBuilder newParcelInfo = NewParcelInfo.builder();

        newParcelInfo.trackingId( parcelEntity.getTrackingId() );

        return newParcelInfo.build();
    }

    @Override
    public ParcelEntity newParcelInfoToParcelEntity(NewParcelInfo newParcelInfo) {
        if ( newParcelInfo == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.trackingId( newParcelInfo.getTrackingId() );

        return parcelEntity.build();
    }

    @Override
    public Parcel parcelEntityToParcel(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        ParcelBuilder parcel = Parcel.builder();

        parcel.weight( parcelEntity.getWeight() );
        parcel.recipient( recipientEntityToRecipient( parcelEntity.getRecipient() ) );
        parcel.sender( recipientEntityToRecipient( parcelEntity.getSender() ) );

        return parcel.build();
    }

    @Override
    public ParcelEntity parcelToParcelEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.weight( parcel.getWeight() );
        parcelEntity.recipient( recipientToRecipientEntity( parcel.getRecipient() ) );
        parcelEntity.sender( recipientToRecipientEntity( parcel.getSender() ) );

        return parcelEntity.build();
    }

    @Override
    public Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        RecipientBuilder recipient = Recipient.builder();

        recipient.name( recipientEntity.getName() );
        recipient.street( recipientEntity.getStreet() );
        recipient.postalCode( recipientEntity.getPostalCode() );
        recipient.city( recipientEntity.getCity() );
        recipient.country( recipientEntity.getCountry() );

        return recipient.build();
    }

    @Override
    public RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.name( recipient.getName() );
        recipientEntity.street( recipient.getStreet() );
        recipientEntity.postalCode( recipient.getPostalCode() );
        recipientEntity.city( recipient.getCity() );
        recipientEntity.country( recipient.getCountry() );

        return recipientEntity.build();
    }

    @Override
    public GeoCoordinate geoCoordinateEntityToGeoCoordinate(GeoCoordinateEntity geoCoordinateEntity) {
        if ( geoCoordinateEntity == null ) {
            return null;
        }

        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat( geoCoordinateEntity.getLat() );
        geoCoordinate.setLon( geoCoordinateEntity.getLon() );

        return geoCoordinate;
    }

    @Override
    public GeoCoordinateEntity geoCoordinateToGeoCoordinateEntity(GeoCoordinate geoCoordinate) {
        if ( geoCoordinate == null ) {
            return null;
        }

        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();

        geoCoordinateEntity.setLat( geoCoordinate.getLat() );
        geoCoordinateEntity.setLon( geoCoordinate.getLon() );

        return geoCoordinateEntity;
    }

    @Override
    public HopEntity hopToHopEntity(Hop hop) {
        if ( hop == null ) {
            return null;
        }

        HopEntity hopEntity = new HopEntity();

        hopEntity.setHopType( hop.getHopType() );
        hopEntity.setCode( hop.getCode() );
        hopEntity.setDescription( hop.getDescription() );
        hopEntity.setProcessingDelayMins( hop.getProcessingDelayMins() );
        hopEntity.setLocationName( hop.getLocationName() );
        hopEntity.setLocationCoordinates( hop.getLocationCoordinates() );

        return hopEntity;
    }

    @Override
    public Hop hopEntityToHop(HopEntity hopEntity) {
        if ( hopEntity == null ) {
            return null;
        }

        Hop hop = new Hop();

        hop.setHopType( hopEntity.getHopType() );
        hop.setCode( hopEntity.getCode() );
        hop.setDescription( hopEntity.getDescription() );
        hop.setProcessingDelayMins( hopEntity.getProcessingDelayMins() );
        hop.setLocationName( hopEntity.getLocationName() );
        hop.setLocationCoordinates( hopEntity.getLocationCoordinates() );

        return hop;
    }

    @Override
    public TransferWarehouse transferWarehouseEntityToTransferWarehouse(TransferWarehouseEntity transferWarehouseEntity) {
        if ( transferWarehouseEntity == null ) {
            return null;
        }

        TransferWarehouse transferWarehouse = new TransferWarehouse();

        transferWarehouse.setRegionGeoJson( transferWarehouseEntity.getRegionGeoJson() );
        transferWarehouse.setLogisticsPartner( transferWarehouseEntity.getLogisticsPartner() );
        transferWarehouse.setLogisticsPartnerUrl( transferWarehouseEntity.getLogisticsPartnerUrl() );

        return transferWarehouse;
    }

    @Override
    public TransferWarehouseEntity transferWarehouseToTransferWarehouseEntity(TransferWarehouse transferwarehouse) {
        if ( transferwarehouse == null ) {
            return null;
        }

        TransferWarehouseEntityBuilder transferWarehouseEntity = TransferWarehouseEntity.builder();

        transferWarehouseEntity.regionGeoJson( transferwarehouse.getRegionGeoJson() );
        transferWarehouseEntity.logisticsPartner( transferwarehouse.getLogisticsPartner() );
        transferWarehouseEntity.logisticsPartnerUrl( transferwarehouse.getLogisticsPartnerUrl() );

        return transferWarehouseEntity.build();
    }

    @Override
    public Truck truckEntityToTruck(TruckEntity truckEntity) {
        if ( truckEntity == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setRegionGeoJson( truckEntity.getRegionGeoJson() );
        truck.setNumberPlate( truckEntity.getNumberPlate() );

        return truck;
    }

    @Override
    public TruckEntity truckToTruckEntity(Truck truck) {
        if ( truck == null ) {
            return null;
        }

        TruckEntity truckEntity = new TruckEntity();

        truckEntity.setRegionGeoJson( truck.getRegionGeoJson() );
        truckEntity.setNumberPlate( truck.getNumberPlate() );

        return truckEntity;
    }

    @Override
    public Warehouse warehouseEntityToWarehouse(WarehouseEntity warehouseEntity) {
        if ( warehouseEntity == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.setLevel( warehouseEntity.getLevel() );
        warehouse.setNextHops( warehouseNextHopsEntityListToWarehouseNextHopsList( warehouseEntity.getNextHops() ) );

        return warehouse;
    }

    @Override
    public WarehouseEntity warehouseToWarehouseEntity(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setLevel( warehouse.getLevel() );
        warehouseEntity.setNextHops( warehouseNextHopsListToWarehouseNextHopsEntityList( warehouse.getNextHops() ) );

        return warehouseEntity;
    }

    @Override
    public WarehouseNextHops warehouseNextHopsEntityToWarehouseNextHops(WarehouseNextHopsEntity warehouseNextHopsEntity) {
        if ( warehouseNextHopsEntity == null ) {
            return null;
        }

        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setTravelTimeMinutes( warehouseNextHopsEntity.getTravelTimeMinutes() );
        warehouseNextHops.setHop( hopEntityToHop( warehouseNextHopsEntity.getHop() ) );

        return warehouseNextHops;
    }

    @Override
    public WarehouseNextHopsEntity warehouseNextHopsToWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHops) {
        if ( warehouseNextHops == null ) {
            return null;
        }

        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();

        warehouseNextHopsEntity.setTravelTimeMinutes( warehouseNextHops.getTravelTimeMinutes() );
        warehouseNextHopsEntity.setHop( hopToHopEntity( warehouseNextHops.getHop() ) );

        return warehouseNextHopsEntity;
    }

    @Override
    public HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntityBuilder hopArrivalEntity = HopArrivalEntity.builder();

        hopArrivalEntity.code( hopArrival.getCode() );
        hopArrivalEntity.description( hopArrival.getDescription() );
        hopArrivalEntity.dateTime( hopArrival.getDateTime() );

        return hopArrivalEntity.build();
    }

    @Override
    public HopArrival hopArrivalEntityToHopArrival(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrivalBuilder hopArrival = HopArrival.builder();

        hopArrival.code( hopArrivalEntity.getCode() );
        hopArrival.description( hopArrivalEntity.getDescription() );
        hopArrival.dateTime( hopArrivalEntity.getDateTime() );

        return hopArrival.build();
    }

    @Override
    public List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> hopArrivalEntityList) {
        if ( hopArrivalEntityList == null ) {
            return null;
        }

        List<HopArrival> list = new ArrayList<HopArrival>( hopArrivalEntityList.size() );
        for ( HopArrivalEntity hopArrivalEntity : hopArrivalEntityList ) {
            list.add( hopArrivalEntityToHopArrival( hopArrivalEntity ) );
        }

        return list;
    }

    @Override
    public List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        List<HopArrivalEntity> list = new ArrayList<HopArrivalEntity>( hopArrivalEntity.size() );
        for ( HopArrival hopArrival : hopArrivalEntity ) {
            list.add( hopArrivalToHopArrivalEntity( hopArrival ) );
        }

        return list;
    }

    protected List<WarehouseNextHops> warehouseNextHopsEntityListToWarehouseNextHopsList(List<WarehouseNextHopsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHops> list1 = new ArrayList<WarehouseNextHops>( list.size() );
        for ( WarehouseNextHopsEntity warehouseNextHopsEntity : list ) {
            list1.add( warehouseNextHopsEntityToWarehouseNextHops( warehouseNextHopsEntity ) );
        }

        return list1;
    }

    protected List<WarehouseNextHopsEntity> warehouseNextHopsListToWarehouseNextHopsEntityList(List<WarehouseNextHops> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHopsEntity> list1 = new ArrayList<WarehouseNextHopsEntity>( list.size() );
        for ( WarehouseNextHops warehouseNextHops : list ) {
            list1.add( warehouseNextHopsToWarehouseNextHopsEntity( warehouseNextHops ) );
        }

        return list1;
    }
}
