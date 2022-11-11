package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repository.WarehouseRepository;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.ObjectMapperImpl;
import at.fhtw.swen3.services.validation.ObjectValidator;

import javax.validation.ConstraintViolationException;

public class WarehouseServiceImpl {
    private WarehouseRepository repository;
    private ObjectMapperImpl mapper;

    public WarehouseServiceImpl(WarehouseRepository repo) { repository = repo; }

    public void submitNewWarehouse(Warehouse warehouse) {
        try {
            ObjectValidator.getInstance().validate(warehouse);
            WarehouseEntity warehouseEntity = mapper.warehouseToWarehouseEntity(warehouse);
            repository.save(warehouseEntity);
        }catch (ConstraintViolationException exception){
            return;
        }
    }
}
