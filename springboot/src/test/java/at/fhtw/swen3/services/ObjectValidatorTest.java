package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.validation.ObjectValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.validation.ConstraintViolationException;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObjectValidatorTest {

    RecipientEntity validRecipientEntity;
    RecipientEntity invalidRecipientEntity;

    ParcelEntity validParcelEntity;
    ParcelEntity invalidParcelEntity;

    NewParcelInfo validNewParcelInfoEntity;
    NewParcelInfo invalidNewParcelInfoEntity;

    TrackingInformation validTrackingInformationEntity;
    TrackingInformation invalidTrackingInformationEntity;

    HopArrivalEntity validHopArrivalEntity;
    HopArrivalEntity invalidHopArrivalEntity;

    Exception exception;
    List<String> expectedOutput;

    @BeforeAll
    void setup(){
        validRecipientEntity = new RecipientEntity(null, "John Doe", "Hoechstaedtplatz 6", "A-1200", "Vienna", "Austria");
        invalidRecipientEntity = new RecipientEntity(null,"jane doe", "Kärtner Straße", "1234", "linz", null);

        validParcelEntity = new ParcelEntity(null, "123456789", TrackingInformation.StateEnum.DELIVERED, new ArrayList<>(), new ArrayList<>(), 1.0f, validRecipientEntity, validRecipientEntity);
        invalidParcelEntity = new ParcelEntity(null, "123", null, new ArrayList<>(), new ArrayList<>(), -1.0f, null, null);

        validHopArrivalEntity = new HopArrivalEntity(null, "TEST1234", "Warehouse 12-27", OffsetDateTime.now(), validParcelEntity);
        invalidHopArrivalEntity = new HopArrivalEntity(null, "TEST12345", "Warehouse 12/27", null, invalidParcelEntity);
    }

    @Test
    void validateRecipientEntity(){

        //Valid
        ObjectValidator.getInstance().validate(validRecipientEntity);

        //Invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidRecipientEntity);
        });
    }

    @Test
    void validateParcelEntity(){

        //Parcel valid
        ObjectValidator.getInstance().validate(validParcelEntity);

        //Parcel invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidParcelEntity);
        });
    }

    @Test
    void validateHopArrivalEntity(){

        //HopArrival valid
        ObjectValidator.getInstance().validate(validHopArrivalEntity);

        //HopArrival invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidHopArrivalEntity);
        });
    }
}