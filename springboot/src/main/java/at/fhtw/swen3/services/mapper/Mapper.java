package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.NewParcelInfo;
import at.fhtw.swen3.persistence.Parcel;
import at.fhtw.swen3.persistence.TrackingInformation;
import at.fhtw.swen3.persistence.entity.EParcel;

@org.mapstruct.Mapper
public interface Mapper {

    TrackingInformation eParcelToTrackingInformation (EParcel eParcel);
    EParcel trackingInformationToEParcel (TrackingInformation trackingInformation);

    NewParcelInfo eParcelToNewParcelInfo (EParcel eParcel);
    EParcel newParcelInfoToEParcel (NewParcelInfo newParcelInfo);

    Parcel eParcelToParcel (EParcel eParcel);
    EParcel parcelToEParcel (Parcel parcel);

}
