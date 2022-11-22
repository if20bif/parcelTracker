package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;

@Mapper
public interface TransferwarehouseMapper {
    Transferwarehouse transferWarehouseEntityToTransferWarehouse(TransferwarehouseEntity transferWarehouseEntity);
    TransferwarehouseEntity transferWarehouseToTransferWarehouseEntity(Transferwarehouse transferwarehouse);
}
