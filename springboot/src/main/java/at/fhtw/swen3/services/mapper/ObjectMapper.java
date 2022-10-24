package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.*;
import at.fhtw.swen3.services.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ObjectMapper {

    TrackingInformation parcelEntityToTrackingInformation (ParcelEntity parcelEntity);
    ParcelEntity trackingInformationToParcelEntity (TrackingInformation trackingInformation);

    NewParcelInfo parcelEntityToNewParcelInfo (ParcelEntity parcelEntity);
    ParcelEntity newParcelInfoToParcelEntity (NewParcelInfo newParcelInfo);

    Parcel parcelEntityToParcel (ParcelEntity parcelEntity);
    ParcelEntity parcelToParcelEntity (Parcel parcel);

    Recipient recipientEntityToRecipient (RecipientEntity recipientEntity);
    RecipientEntity recipientToRecipientEntity (Recipient recipient);

    GeoCoordinate geoCoordinateEntityToGeoCoordinate(GeoCoordinateEntity geoCoordinateEntity);
    GeoCoordinateEntity geoCoordinateToGeoCoordinateEntity(GeoCoordinate geoCoordinate);

    HopEntity hopToHopEntity (Hop hop);
    Hop hopEntityToHop (HopEntity hopEntity);

    TransferWarehouse transferWarehouseEntityToTransferWarehouse(TransferWarehouseEntity transferWarehouseEntity);
    TransferWarehouseEntity transferWarehouseToTransferWarehouseEntity(TransferWarehouse transferwarehouse);

    Truck truckEntityToTruck(TruckEntity truckEntity);
    TruckEntity truckToTruckEntity(Truck truck);

    Warehouse warehouseEntityToWarehouse(WarehouseEntity warehouseEntity);
    WarehouseEntity warehouseToWarehouseEntity(Warehouse warehouse);

    WarehouseNextHops warehouseNextHopsEntityToWarehouseNextHops(WarehouseNextHopsEntity warehouseNextHopsEntity);
    WarehouseNextHopsEntity warehouseNextHopsToWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHops);

    HopArrivalEntity hopArrivalToHopArrivalEntity (HopArrival hopArrival);
    HopArrival hopArrivalEntityToHopArrival (HopArrivalEntity hopArrivalEntity);

    List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> hopArrivalEntityList);

    List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> hopArrivalEntity);
}
