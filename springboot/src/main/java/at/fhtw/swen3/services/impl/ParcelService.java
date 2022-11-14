package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import java.util.Optional;

public interface ParcelService {

    public Optional<Parcel> updateStatus(String trackingId, TrackingInformation.StateEnum state);

    public void reportParcelHop();

    public Optional<NewParcelInfo> createParcel(Parcel parcel);

    public Optional<TrackingInformation> getTrackingInformation(String trackingId);

    public void transitionParcel(Parcel parcel);

}
