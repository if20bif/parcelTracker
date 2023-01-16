package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;

public abstract class HopMapperDecorator implements HopMapper {

    private final HopMapper delegate;

    protected HopMapperDecorator(HopMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public HopEntity hopToHopEntity(Hop hop) {
        if (hop instanceof Transferwarehouse transferwarehouse) {
            return TransferwarehouseMapper.INSTANCE.transferWarehouseToTransferWarehouseEntity(transferwarehouse);
        } else if (hop instanceof Truck truck) {
            return TruckMapper.INSTANCE.truckToTruckEntity(truck);
        } else if (hop instanceof Warehouse warehouse) {
            return WarehouseMapper.INSTANCE.warehouseToWarehouseEntity(warehouse);
        }
        return delegate.hopToHopEntity(hop);
    }

    @Override
    public Hop hopEntityToHop(HopEntity hopEntity) {
        if (hopEntity instanceof TransferwarehouseEntity transferwarehouseEntity) {
            return TransferwarehouseMapper.INSTANCE.transferWarehouseEntityToTransferWarehouse(transferwarehouseEntity);
        } else if (hopEntity instanceof TruckEntity truckEntity) {
            return TruckMapper.INSTANCE.truckEntityToTruck(truckEntity);
        } else if (hopEntity instanceof WarehouseEntity warehouseEntity) {
            return WarehouseMapper.INSTANCE.warehouseEntityToWarehouse(warehouseEntity);
        }
        return delegate.hopEntityToHop(hopEntity);
    }
}