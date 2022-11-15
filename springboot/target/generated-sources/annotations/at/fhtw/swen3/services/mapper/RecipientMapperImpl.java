package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.Recipient.RecipientBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T19:34:44+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
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

    @Override
    public RecipientEntity recipientToRecipientEntity(Recipient recipient) {
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
}
