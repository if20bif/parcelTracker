package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-11T16:37:34+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MapperImpl implements Mapper {

    @Override
    public TrackingInformation ParcelEntityToTrackingInformation(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        TrackingInformation trackingInformation = new TrackingInformation();

        return trackingInformation;
    }

    @Override
    public ParcelEntity trackingInformationToParcelEntity(TrackingInformation trackingInformation) {
        if ( trackingInformation == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        return parcelEntity;
    }

    @Override
    public NewParcelInfo ParcelEntityToNewParcelInfo(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        return newParcelInfo;
    }

    @Override
    public ParcelEntity newParcelInfoToParcelEntity(NewParcelInfo newParcelInfo) {
        if ( newParcelInfo == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        return parcelEntity;
    }

    @Override
    public Parcel ParcelEntityToParcel(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        Parcel parcel = new Parcel();

        return parcel;
    }

    @Override
    public ParcelEntity parcelToParcelEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        return parcelEntity;
    }

    @Override
    public List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        List<HopArrival> list = new ArrayList<HopArrival>( hopArrivalEntity.size() );
        for ( HopArrivalEntity hopArrivalEntity1 : hopArrivalEntity ) {
            list.add( hopArrivalToHopArrivalEntity( hopArrivalEntity1 ) );
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

    @Override
    public Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        return recipient;
    }

    @Override
    public RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntity recipientEntity = new RecipientEntity();

        return recipientEntity;
    }

    @Override
    public HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();

        return hopArrivalEntity;
    }

    @Override
    public HopArrival hopArrivalToHopArrivalEntity(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrival hopArrival = new HopArrival();

        return hopArrival;
    }
}
