package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity.TransferWarehouseEntityBuilder;
import at.fhtw.swen3.services.dto.TransferWarehouse;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T19:34:44+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class TransferWarehouseMapperImpl implements TransferWarehouseMapper {

    @Override
    public TransferWarehouse transferWarehouseEntityToTransferWarehouse(TransferWarehouseEntity transferWarehouseEntity) {
        if ( transferWarehouseEntity == null ) {
            return null;
        }

        TransferWarehouse transferWarehouse = new TransferWarehouse();

        transferWarehouse.setRegionGeoJson( transferWarehouseEntity.getRegionGeoJson() );
        transferWarehouse.setLogisticsPartner( transferWarehouseEntity.getLogisticsPartner() );
        transferWarehouse.setLogisticsPartnerUrl( transferWarehouseEntity.getLogisticsPartnerUrl() );

        return transferWarehouse;
    }

    @Override
    public TransferWarehouseEntity transferWarehouseToTransferWarehouseEntity(TransferWarehouse transferwarehouse) {
        if ( transferwarehouse == null ) {
            return null;
        }

        TransferWarehouseEntityBuilder transferWarehouseEntity = TransferWarehouseEntity.builder();

        transferWarehouseEntity.regionGeoJson( transferwarehouse.getRegionGeoJson() );
        transferWarehouseEntity.logisticsPartner( transferwarehouse.getLogisticsPartner() );
        transferWarehouseEntity.logisticsPartnerUrl( transferwarehouse.getLogisticsPartnerUrl() );

        return transferWarehouseEntity.build();
    }
}
