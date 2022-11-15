package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WarehouseMapperTest {

    private WarehouseMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new WarehouseMapperImpl();
    }

    @Test
    void warehouseEntityToWarehouse() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setLevel(10);
        warehouseEntity.setNextHops(new ArrayList<>());

        Warehouse warehouse = mapper.warehouseEntityToWarehouse(warehouseEntity);

        assertEquals(10, warehouse.getLevel());
        assertNotNull(warehouse.getNextHops());
    }

    @Test
    void warehouseToWarehouseEntity() {
        Warehouse warehouse = new Warehouse();

        warehouse.setLevel(10);
        warehouse.setNextHops(new ArrayList<>());

        WarehouseEntity warehouseEntity = mapper.warehouseToWarehouseEntity(warehouse);

        assertEquals(10, warehouseEntity.getLevel());
        assertNotNull(warehouseEntity.getNextHops());
    }
}