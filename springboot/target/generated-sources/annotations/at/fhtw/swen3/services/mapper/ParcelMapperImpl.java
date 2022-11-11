package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity.HopArrivalEntityBuilder;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.HopArrival.HopArrivalBuilder;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.NewParcelInfo.NewParcelInfoBuilder;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Parcel.ParcelBuilder;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.Recipient.RecipientBuilder;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.dto.TrackingInformation.TrackingInformationBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-11T18:05:23+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public Parcel parcelEntityToParcel(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        ParcelBuilder parcel = Parcel.builder();

        parcel.weight( parcelEntity.getWeight() );
        parcel.recipient( recipientEntityToRecipient( parcelEntity.getRecipient() ) );
        parcel.sender( recipientEntityToRecipient( parcelEntity.getSender() ) );

        return parcel.build();
    }

    @Override
    public ParcelEntity parcelToParcelEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.weight( parcel.getWeight() );
        parcelEntity.recipient( recipientToRecipientEntity( parcel.getRecipient() ) );
        parcelEntity.sender( recipientToRecipientEntity( parcel.getSender() ) );

        return parcelEntity.build();
    }

    @Override
    public NewParcelInfo parcelEntityToNewParcelInfo(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        NewParcelInfoBuilder newParcelInfo = NewParcelInfo.builder();

        newParcelInfo.trackingId( parcelEntity.getTrackingId() );

        return newParcelInfo.build();
    }

    @Override
    public ParcelEntity newParcelInfoToParcelEntity(NewParcelInfo newParcelInfo) {
        if ( newParcelInfo == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.trackingId( newParcelInfo.getTrackingId() );

        return parcelEntity.build();
    }

    @Override
    public TrackingInformation parcelEntityToTrackingInformation(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        TrackingInformationBuilder trackingInformation = TrackingInformation.builder();

        trackingInformation.state( parcelEntity.getState() );
        trackingInformation.visitedHops( hopArrivalEntityListToHopArrivalList( parcelEntity.getVisitedHops() ) );
        trackingInformation.futureHops( hopArrivalEntityListToHopArrivalList( parcelEntity.getFutureHops() ) );

        return trackingInformation.build();
    }

    @Override
    public ParcelEntity trackingInformationToParcelEntity(TrackingInformation trackingInformation) {
        if ( trackingInformation == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.state( trackingInformation.getState() );
        parcelEntity.visitedHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getVisitedHops() ) );
        parcelEntity.futureHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getFutureHops() ) );

        return parcelEntity.build();
    }

    protected Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        RecipientBuilder recipient = Recipient.builder();

        recipient.name( recipientEntity.getName() );
        recipient.street( recipientEntity.getStreet() );
        recipient.postalCode( recipientEntity.getPostalCode() );
        recipient.city( recipientEntity.getCity() );
        recipient.country( recipientEntity.getCountry() );

        return recipient.build();
    }

    protected RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.name( recipient.getName() );
        recipientEntity.street( recipient.getStreet() );
        recipientEntity.postalCode( recipient.getPostalCode() );
        recipientEntity.city( recipient.getCity() );
        recipientEntity.country( recipient.getCountry() );

        return recipientEntity.build();
    }

    protected HopArrival hopArrivalEntityToHopArrival(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrivalBuilder hopArrival = HopArrival.builder();

        hopArrival.code( hopArrivalEntity.getCode() );
        hopArrival.description( hopArrivalEntity.getDescription() );
        hopArrival.dateTime( hopArrivalEntity.getDateTime() );

        return hopArrival.build();
    }

    protected List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<HopArrival> list1 = new ArrayList<HopArrival>( list.size() );
        for ( HopArrivalEntity hopArrivalEntity : list ) {
            list1.add( hopArrivalEntityToHopArrival( hopArrivalEntity ) );
        }

        return list1;
    }

    protected HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntityBuilder hopArrivalEntity = HopArrivalEntity.builder();

        hopArrivalEntity.code( hopArrival.getCode() );
        hopArrivalEntity.description( hopArrival.getDescription() );
        hopArrivalEntity.dateTime( hopArrival.getDateTime() );

        return hopArrivalEntity.build();
    }

    protected List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> list) {
        if ( list == null ) {
            return null;
        }

        List<HopArrivalEntity> list1 = new ArrayList<HopArrivalEntity>( list.size() );
        for ( HopArrival hopArrival : list ) {
            list1.add( hopArrivalToHopArrivalEntity( hopArrival ) );
        }

        return list1;
    }
}
