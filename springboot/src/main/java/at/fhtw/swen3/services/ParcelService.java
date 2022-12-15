package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import java.io.IOException;
import java.util.Optional;

public interface ParcelService {

    public Optional<Parcel> updateStatus(String trackingId, TrackingInformation.StateEnum state);

    public void reportParcelHop();

    public Optional<NewParcelInfo> createParcel(Parcel parcel) throws IOException;

    public Optional<TrackingInformation> getTrackingInformation(String trackingId);

    public void transitionParcel(String trackingId, Parcel parcel) throws IOException;

}
