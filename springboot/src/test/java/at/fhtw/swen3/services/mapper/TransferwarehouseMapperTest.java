package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransferwarehouseMapperTest {

    private TransferwarehouseMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new TransferwarehouseMapperImpl();
    }

    @Test
    void transferWarehouseEntityToTransferWarehouse() {
        TransferwarehouseEntity transferWarehouseEntity = new TransferwarehouseEntity();

        transferWarehouseEntity.setLogisticsPartnerUrl("URL");
        transferWarehouseEntity.setRegionGeoJson("REGION");
        transferWarehouseEntity.setLogisticsPartner("PARTNER");

        Transferwarehouse transferWarehouse = mapper.transferWarehouseEntityToTransferWarehouse(transferWarehouseEntity);

        assertTrue(transferWarehouse.getLogisticsPartnerUrl().equals("URL"));
        assertTrue(transferWarehouse.getRegionGeoJson().equals("REGION"));
        assertTrue(transferWarehouse.getLogisticsPartner().equals("PARTNER"));
    }

    @Test
    void transferWarehouseToTransferWarehouseEntity() {
        Transferwarehouse transferWarehouse = new Transferwarehouse();

        transferWarehouse.setLogisticsPartnerUrl("URL");
        transferWarehouse.setRegionGeoJson("REGION");
        transferWarehouse.setLogisticsPartner("PARTNER");

        TransferwarehouseEntity transferWarehouseEntity = mapper.transferWarehouseToTransferWarehouseEntity(transferWarehouse);

        assertTrue(transferWarehouseEntity.getLogisticsPartnerUrl().equals("URL"));
        assertTrue(transferWarehouseEntity.getRegionGeoJson().equals("REGION"));
        assertTrue(transferWarehouseEntity.getLogisticsPartner().equals("PARTNER"));
    }
}