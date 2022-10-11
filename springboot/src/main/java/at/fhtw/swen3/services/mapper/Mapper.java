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

    TrackingInformation ParcelEntityToTrackingInformation (ParcelEntity parcelEntity);
    ParcelEntity trackingInformationToParcelEntity (TrackingInformation trackingInformation);

    NewParcelInfo ParcelEntityToNewParcelInfo (ParcelEntity parcelEntity);
    ParcelEntity newParcelInfoToParcelEntity (NewParcelInfo newParcelInfo);

    Parcel ParcelEntityToParcel (ParcelEntity parcelEntity);
    ParcelEntity parcelToParcelEntity (Parcel parcel);

    List<HopArrival> hopArrivalEntityListToHopArrivalList (List<HopArrivalEntity> hopArrivalEntity);
    List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList (List<HopArrival> hopArrivalEntity);

    Recipient recipientEntityToRecipient (RecipientEntity recipientEntity);
    RecipientEntity recipientToRecipientEntity (Recipient recipient);

    HopArrivalEntity hopArrivalToHopArrivalEntity (HopArrival hopArrival);
    HopArrival hopArrivalToHopArrivalEntity (HopArrivalEntity hopArrivalEntity);
}
