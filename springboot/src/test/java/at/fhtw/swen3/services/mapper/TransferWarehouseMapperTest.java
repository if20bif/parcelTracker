package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.TransferWarehouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransferWarehouseMapperTest {

    private TransferWarehouseMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new TransferWarehouseMapperImpl();
    }

    @Test
    void transferWarehouseEntityToTransferWarehouse() {
        TransferWarehouseEntity transferWarehouseEntity = new TransferWarehouseEntity();

        transferWarehouseEntity.setLogisticsPartnerUrl("URL");
        transferWarehouseEntity.setRegionGeoJson("REGION");
        transferWarehouseEntity.setLogisticsPartner("PARTNER");

        TransferWarehouse transferWarehouse = mapper.transferWarehouseEntityToTransferWarehouse(transferWarehouseEntity);

        assertTrue(transferWarehouse.getLogisticsPartnerUrl().equals("URL"));
        assertTrue(transferWarehouse.getRegionGeoJson().equals("REGION"));
        assertTrue(transferWarehouse.getLogisticsPartner().equals("PARTNER"));
    }

    @Test
    void transferWarehouseToTransferWarehouseEntity() {
        TransferWarehouse transferWarehouse = new TransferWarehouse();

        transferWarehouse.setLogisticsPartnerUrl("URL");
        transferWarehouse.setRegionGeoJson("REGION");
        transferWarehouse.setLogisticsPartner("PARTNER");

        TransferWarehouseEntity transferWarehouseEntity = mapper.transferWarehouseToTransferWarehouseEntity(transferWarehouse);

        assertTrue(transferWarehouseEntity.getLogisticsPartnerUrl().equals("URL"));
        assertTrue(transferWarehouseEntity.getRegionGeoJson().equals("REGION"));
        assertTrue(transferWarehouseEntity.getLogisticsPartner().equals("PARTNER"));
    }
}