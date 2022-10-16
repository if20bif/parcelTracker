package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.mapstruct.Mapper
public interface Mapper {

    TrackingInformation parcelEntityToTrackingInformation (ParcelEntity parcelEntity);
    ParcelEntity trackingInformationToParcelEntity (TrackingInformation trackingInformation);

    NewParcelInfo parcelEntityToNewParcelInfo (ParcelEntity parcelEntity);
    ParcelEntity newParcelInfoToParcelEntity (NewParcelInfo newParcelInfo);

    Parcel parcelEntityToParcel (ParcelEntity parcelEntity);
    ParcelEntity parcelToParcelEntity (Parcel parcel);

    Recipient recipientEntityToRecipient (RecipientEntity recipientEntity);
    RecipientEntity recipientToRecipientEntity (Recipient recipient);

    HopArrivalEntity hopArrivalToHopArrivalEntity (HopArrival hopArrival);
    HopArrival hopArrivalEntityToHopArrival (HopArrivalEntity hopArrivalEntity);

    List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> hopArrivalEntityList);

    List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> hopArrivalEntity);
}
