package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.*;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParcelMapStruct implements Mapper{

    @Override
    public TrackingInformation ParcelEntityToTrackingInformation(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        return TrackingInformation.builder()
                .futureHops(hopArrivalEntityToHopArrival(parcelEntity.getFutureHops()))
                .visitedHops(hopArrivalEntityToHopArrival(parcelEntity.getVisitedHops()))
                .state(parcelEntity.getState())
                .build();
    }

    @Override
    public ParcelEntity trackingInformationToParcelEntity(TrackingInformation trackingInformation) {
        if ( trackingInformation == null ) {
            return null;
        }

        return ParcelEntity.builder()
                .futureHops(hopArrivalToHopArrivalEntity(trackingInformation.getFutureHops()))
                .visitedHops(hopArrivalToHopArrivalEntity(trackingInformation.getVisitedHops()))
                .state(trackingInformation.getState())
                .build();
    }

    @Override
    public NewParcelInfo ParcelEntityToNewParcelInfo(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        return NewParcelInfo.builder()
                .trackingId(parcelEntity.getTrackingId())
                .build();
    }

    @Override
    public ParcelEntity newParcelInfoToParcelEntity(NewParcelInfo newParcelInfo) {
        if ( newParcelInfo == null ) {
            return null;
        }

        return ParcelEntity.builder()
                .trackingId(newParcelInfo.getTrackingId())
                .build();
    }

    @Override
    public Parcel ParcelEntityToParcel(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        return Parcel.builder()
                .weight(parcelEntity.getWeight())
                .recipient(recipientEntityToRecipient(parcelEntity.getRecipient()))
                .sender(recipientEntityToRecipient(parcelEntity.getSender()))
                .build();
    }

    @Override
    public ParcelEntity parcelToParcelEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        return ParcelEntity.builder()
                .weight(parcel.getWeight())
                .recipient(recipientToRecipientEntity(parcel.getRecipient()))
                .sender(recipientToRecipientEntity(parcel.getSender()))
                .build();
    }

    @Override
    public List<HopArrival> hopArrivalEntityToHopArrival(List<HopArrivalEntity> hopArrivalEntity) {
        return null;
    }

    @Override
    public List<HopArrivalEntity> hopArrivalToHopArrivalEntity(List<HopArrival> hopArrivalEntity) {
        return null;
    }

    @Override
    public Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        return Recipient.builder()
                .name(recipientEntity.getName())
                .street(recipientEntity.getStreet())
                .postalCode(recipientEntity.getPostalCode())
                .city(recipientEntity.getCity())
                .country(recipientEntity.getCountry())
                .build();
    }

    @Override
    public RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        return RecipientEntity.builder()
                .name(recipient.getName())
                .street(recipient.getStreet())
                .postalCode(recipient.getPostalCode())
                .city(recipient.getCity())
                .country(recipient.getCountry())
                .build();
    }


}
