package at.fhtw.swen3.services;

import at.fhtw.swen3.services.ObjectValidator;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObjectValidatorTest {

    @Test
    void validate() {

        Recipient validRecipient = new Recipient("John Doe", "Hoechstaedtplatz 6", "A-1200", "Vienna", "Austria");
        Recipient invalidRecipient = new Recipient("jane doe", "Kärtner Straße", "1234", "linz", null);

        Parcel validParcel = new Parcel(1.0f, validRecipient, validRecipient);
        Parcel invalidParcel = new Parcel(-1.0f, null, null);

        NewParcelInfo validNewParcelInfo = new NewParcelInfo("123456789");
        NewParcelInfo invalidNewParcelInfo = new NewParcelInfo("123");

        TrackingInformation validTrackingInformation = new TrackingInformation(TrackingInformation.StateEnum.TRANSFERRED, new ArrayList<>(), new ArrayList<>());
        TrackingInformation invalidTrackingInformation = new TrackingInformation();

        HopArrival validHopArrival = new HopArrival("TEST1234", "Warehouse 12-27", OffsetDateTime.now());
        HopArrival invalidHopArrival = new HopArrival("TEST12345", "Warehouse 12/27", null);

        Exception exception;
        List<String> expectedOutput;

        //Recipient valid

        ObjectValidator.getInstance().validate(validRecipient);

        //Recipient invalid

        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidRecipient);
        });

        expectedOutput = new ArrayList<>(
                Arrays.asList("street: must match \"[A-Zßa-z]+ [0-9]+[0-9a-z/]*\"", "name: must match \"[A-Z][A-Za-z0-9- ]*\"", "city: must match \"[A-Z][A-Za-z0-9- ]*\"", "postalCode: must match \"A-[0-9]{4}\"", "country: must not be null")
        );
        String invalidRecipientOutput = exception.getMessage();

        expectedOutput.forEach(v -> assertTrue(invalidRecipientOutput.contains(v)));

        //Parcel valid

        ObjectValidator.getInstance().validate(validParcel);

        //Parcel invalid

        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidParcel);
        });

        expectedOutput = new ArrayList<>(
                Arrays.asList("weight: must be greater than or equal to 0", "sender: must not be null", "recipient: must not be null")
        );
        String invalidParcelOutput = exception.getMessage();

        expectedOutput.forEach(v -> assertTrue(invalidParcelOutput.contains(v)));

        //NewParcelInfo valid

        ObjectValidator.getInstance().validate(validNewParcelInfo);

        //NewParcelInfo invalid

        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidNewParcelInfo);
        });

        expectedOutput = new ArrayList<>(
                Arrays.asList("trackingId: must match \"^[A-Z0-9]{9}$\"")
        );
        String invalidNewParcelInfoOutput = exception.getMessage();

        expectedOutput.forEach(v -> assertTrue(invalidNewParcelInfoOutput.contains(v)));

        //TrackingInformation valid

        ObjectValidator.getInstance().validate(validTrackingInformation);

        //TrackingInformation invalid

        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidTrackingInformation);
        });

        expectedOutput = new ArrayList<>(
                Arrays.asList("state: must not be null")
        );
        String invalidTrackingInformationOutput = exception.getMessage();

        expectedOutput.forEach(v -> assertTrue(invalidTrackingInformationOutput.contains(v)));

        //HopArrival valid

        ObjectValidator.getInstance().validate(validHopArrival);

        //HopArrival invalid

        exception = assertThrows(ConstraintViolationException.class, () -> {
            ObjectValidator.getInstance().validate(invalidHopArrival);
        });

        expectedOutput = new ArrayList<>(
                Arrays.asList("dateTime: must not be null", "code: must match \"^[A-Z]{4}\\d{1,4}$\"", "description: must match \"[A-Za-z0-9- ]+\"")
        );
        String invalidHopArrivalOutput = exception.getMessage();

        expectedOutput.forEach(v -> assertTrue(invalidHopArrivalOutput.contains(v)));

    }
}