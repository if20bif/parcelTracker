package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repository.ParcelRepository;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ObjectMapperImpl;
import at.fhtw.swen3.services.validation.ObjectValidator;

import javax.validation.ConstraintViolationException;

public class ParcelServiceImpl implements ParcelService{
    private ParcelRepository repository;
    private ObjectMapperImpl mapper;

    public ParcelServiceImpl(ParcelRepository repo) { repository = repo; }

    public void submitNewParcel(Parcel parcel) {
        try {
            ObjectValidator.getInstance().validate(parcel);
            ParcelEntity parcelEntitiy = mapper.parcelToParcelEntity(parcel);
            repository.save(parcelEntitiy);
        }catch (ConstraintViolationException exception){
            return;
        }
    }
}
