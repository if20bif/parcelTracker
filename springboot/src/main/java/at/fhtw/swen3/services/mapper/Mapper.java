package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.persistence.entity.ParcelEntity;

@org.mapstruct.Mapper
public interface Mapper {

    TrackingInformation eParcelToTrackingInformation (ParcelEntity parcelEntity);
    ParcelEntity trackingInformationToEParcel (TrackingInformation trackingInformation);

    NewParcelInfo eParcelToNewParcelInfo (ParcelEntity parcelEntity);
    ParcelEntity newParcelInfoToEParcel (NewParcelInfo newParcelInfo);

    Parcel eParcelToParcel (ParcelEntity parcelEntity);
    ParcelEntity parcelToEParcel (Parcel parcel);

}
