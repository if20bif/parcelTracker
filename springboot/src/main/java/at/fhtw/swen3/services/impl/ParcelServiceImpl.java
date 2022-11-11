package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repository.ParcelRepository;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import at.fhtw.swen3.services.validation.ObjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

public class ParcelServiceImpl implements ParcelService{
    private final ParcelRepository repository;
    private ParcelMapperImpl mapper;

    public ParcelServiceImpl(ParcelRepository repo) { repository = repo; }

    public void submitNewParcel(Parcel parcel) {
        try {
            log.info("Submitting new parcel: " + parcel);
            ObjectValidator.getInstance().validate(parcel);
            ParcelEntity parcelEntitiy = mapper.parcelToParcelEntity(parcel);
            repository.save(parcelEntitiy);
        }catch (ConstraintViolationException exception){
            return;
        }
    }
}
