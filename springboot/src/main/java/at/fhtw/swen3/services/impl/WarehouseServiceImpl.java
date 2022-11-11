package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapperImpl;
import at.fhtw.swen3.services.validation.ObjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@RequiredArgsConstructor
@Slf4j
@Service
public class WarehouseServiceImpl {
    private final WarehouseRepository repository;
    private WarehouseMapperImpl mapper;

    //public WarehouseServiceImpl(WarehouseRepository repo) { repository = repo; }

    public void submitNewWarehouse(Warehouse warehouse) {
        try {
            log.info("Submitting new warehouse: " + warehouse);
            ObjectValidator.getInstance().validate(warehouse);
            WarehouseEntity warehouseEntity = mapper.warehouseToWarehouseEntity(warehouse);
            repository.save(warehouseEntity);
        }catch (ConstraintViolationException exception){
            return;
        }
    }
}
