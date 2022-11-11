package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;

@Mapper
public interface ParcelMapper {
    Parcel parcelEntityToParcel (ParcelEntity parcelEntity);
    ParcelEntity parcelToParcelEntity (Parcel parcel);

    NewParcelInfo parcelEntityToNewParcelInfo (ParcelEntity parcelEntity);
    ParcelEntity newParcelInfoToParcelEntity (NewParcelInfo newParcelInfo);

    TrackingInformation parcelEntityToTrackingInformation (ParcelEntity parcelEntity);
    ParcelEntity trackingInformationToParcelEntity (TrackingInformation trackingInformation);
}
