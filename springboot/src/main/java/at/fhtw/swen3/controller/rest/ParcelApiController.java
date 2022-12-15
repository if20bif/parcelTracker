package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.ParcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:14:49.172303Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    @Autowired
    private final NativeWebRequest request;

    @Autowired
    private final ParcelService parcelService;

    public ParcelApiController(NativeWebRequest nativeWebRequest, ParcelService parcelService){
        this.request = nativeWebRequest;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId){
        log.info("reportParcelDelivery called.");

        if(parcelService.updateStatus(trackingId, TrackingInformation.StateEnum.DELIVERED).isPresent())
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code){
        log.info("reportParcelHop called.");

        parcelService.reportParcelHop();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel){
        log.info("submitParcel called.");

        try{
            Optional<NewParcelInfo> result = parcelService.createParcel(parcel);

            if(result.isPresent())
                return new ResponseEntity<>(result.get(), HttpStatus.CREATED);

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ConstraintViolationException | IOException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId){
        log.info("trackParcel called.");

        Optional<TrackingInformation> result = parcelService.getTrackingInformation(trackingId);

        if(result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        log.info("transtionParcel called.");

        try {
            parcelService.transitionParcel(trackingId, parcel);
        } catch (ConstraintViolationException | IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
