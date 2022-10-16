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
    date = "2022-10-16T20:29:07+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
public class MapperImpl implements Mapper {

    @Override
    public TrackingInformation parcelEntityToTrackingInformation(ParcelEntity parcelEntity) {
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
    public NewParcelInfo parcelEntityToNewParcelInfo(ParcelEntity parcelEntity) {
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
    public Parcel parcelEntityToParcel(ParcelEntity parcelEntity) {
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
    public HopArrival hopArrivalEntityToHopArrival(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrival hopArrival = new HopArrival();

        return hopArrival;
    }

    @Override
    public List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> hopArrivalEntityList) {
        if ( hopArrivalEntityList == null ) {
            return null;
        }

        List<HopArrival> list = new ArrayList<HopArrival>( hopArrivalEntityList.size() );
        for ( HopArrivalEntity hopArrivalEntity : hopArrivalEntityList ) {
            list.add( hopArrivalEntityToHopArrival( hopArrivalEntity ) );
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
}
