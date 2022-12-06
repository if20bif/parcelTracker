package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import at.fhtw.swen3.services.validation.ObjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ParcelServiceImpl implements ParcelService {
    private final ParcelRepository repository;
    private ParcelMapperImpl mapper = new ParcelMapperImpl();

    //public ParcelServiceImpl(ParcelRepository repo) { repository = repo; }

    public void submitNewParcel(Parcel parcel) {
        try {
            log.info("Submitting new parcel: " + parcel);
            ObjectValidator.getInstance().validate(parcel);
            ParcelEntity parcelEntity = mapper.parcelToParcelEntity(parcel);
            repository.save(parcelEntity);
        }catch (ConstraintViolationException exception){
            log.warn("Constraint violation: " + exception);
            return;
        }
    }

    @Override
    public void reportParcelHop(){
        //TODO
    }

    @Override
    public Optional<Parcel> updateStatus(String trackingId, TrackingInformation.StateEnum state){
        List<ParcelEntity> list = repository.findByTrackingId(trackingId);

        if(list.isEmpty()){
            log.warn("Status list is empty!");
            return Optional.empty();
        }

        ParcelEntity parcelEntity = list.get(0);
        parcelEntity.setState(state);
        repository.save(parcelEntity);
        log.info("Status updated");

        return Optional.of(mapper.parcelEntityToParcel(parcelEntity));
    }

    @Override
    public Optional<NewParcelInfo> createParcel(Parcel parcel) throws ConstraintViolationException {

        ParcelEntity parcelEntity = mapper.parcelToParcelEntity(parcel);

        parcelEntity.setTrackingId("PYJRB4HZ6");

        try{
            ObjectValidator.getInstance().validate(parcelEntity);
            ObjectValidator.getInstance().validate(parcelEntity.getRecipient());
            ObjectValidator.getInstance().validate(parcelEntity.getSender());
        } catch (HibernateError e) {
            log.warn("Invalid Parcel");
            return Optional.empty();
        }

        repository.save(parcelEntity);

        log.info("Parcel created");
        return Optional.of(mapper.parcelEntityToNewParcelInfo(parcelEntity));
    }

    @Override
    public Optional<TrackingInformation> getTrackingInformation(String trackingId){
        List<ParcelEntity> list = repository.findByTrackingId(trackingId);

        if(list.isEmpty()){
            log.warn("TrackingInformation list is empty!");
            return Optional.empty();
        }

        log.info("Return TrackingInformation");

        return Optional.of(mapper.parcelEntityToTrackingInformation(list.get(0)));
    }

    @Override
    public void transitionParcel(Parcel parcel){

    }
}
