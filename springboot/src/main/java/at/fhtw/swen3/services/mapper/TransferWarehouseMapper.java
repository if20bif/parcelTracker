package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.TransferWarehouse;
import org.mapstruct.Mapper;

@Mapper
public interface TransferWarehouseMapper {
    TransferWarehouse transferWarehouseEntityToTransferWarehouse(TransferWarehouseEntity transferWarehouseEntity);
    TransferWarehouseEntity transferWarehouseToTransferWarehouseEntity(TransferWarehouse transferwarehouse);
}
