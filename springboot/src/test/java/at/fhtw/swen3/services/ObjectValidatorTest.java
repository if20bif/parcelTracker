package at.fhtw.swen3.services;

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

    Recipient validRecipient;
    Recipient invalidRecipient;

    Parcel validParcel;
    Parcel invalidParcel;

    NewParcelInfo validNewParcelInfo;
    NewParcelInfo invalidNewParcelInfo;

    TrackingInformation validTrackingInformation;
    TrackingInformation invalidTrackingInformation;

    HopArrival validHopArrival;
    HopArrival invalidHopArrival;

    Exception exception;
    List<String> expectedOutput;

    @BeforeAll
    void setup(){
        validRecipient = new Recipient("John Doe", "Hoechstaedtplatz 6", "A-1200", "Vienna", "Austria");
        invalidRecipient = new Recipient("jane doe", "Kärtner Straße", "1234", "linz", null);

        validParcel = new Parcel(1.0f, validRecipient, validRecipient);
        invalidParcel = new Parcel(-1.0f, null, null);

        validNewParcelInfo = new NewParcelInfo("123456789");
        invalidNewParcelInfo = new NewParcelInfo("123");

        validTrackingInformation = new TrackingInformation(TrackingInformation.StateEnum.TRANSFERRED, new ArrayList<>(), new ArrayList<>());
        invalidTrackingInformation = new TrackingInformation();

        validHopArrival = new HopArrival("TEST1234", "Warehouse 12-27", OffsetDateTime.now());
        invalidHopArrival = new HopArrival("TEST12345", "Warehouse 12/27", null);
    }

    @Test
    void validateRecipient(){

        //Valid
        ObjectValidator.getInstance().validate(validRecipient);

        //Invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidRecipient);
        });
    }

    @Test
    void validateParcel(){

        //Parcel valid
        ObjectValidator.getInstance().validate(validParcel);

        //Parcel invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidParcel);
        });
    }

    @Test
    void validateNewParcelInfo(){

        //NewParcelInfo valid
        ObjectValidator.getInstance().validate(validNewParcelInfo);

        //NewParcelInfo invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidNewParcelInfo);
        });
    }

    @Test
    void validateTrackingInformation(){

        //TrackingInformation valid
        ObjectValidator.getInstance().validate(validTrackingInformation);

        //TrackingInformation invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidTrackingInformation);
        });
    }

    @Test
    void validateHopArrival(){

        //HopArrival valid
        ObjectValidator.getInstance().validate(validHopArrival);

        //HopArrival invalid
        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidHopArrival);
        });
    }
}