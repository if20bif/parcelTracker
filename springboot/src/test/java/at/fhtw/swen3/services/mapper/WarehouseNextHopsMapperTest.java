package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WarehouseNextHopsMapperTest {

    private WarehouseNextHopsMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new WarehouseNextHopsMapperImpl();
    }

    @Test
    void warehouseNextHopsEntityToWarehouseNextHops() {
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();

        warehouseNextHopsEntity.setTravelTimeMinutes(10);
        warehouseNextHopsEntity.setHop(new HopEntity());

        WarehouseNextHops warehouseNextHops = mapper.warehouseNextHopsEntityToWarehouseNextHops(warehouseNextHopsEntity);

        assertEquals(10, warehouseNextHops.getTravelTimeMinutes());
        assertNotNull(warehouseNextHops.getHop());
    }

    @Test
    void warehouseNextHopsToWarehouseNextHopsEntity() {
        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setTravelTimeMinutes(10);
        warehouseNextHops.setHop(new Hop());

        WarehouseNextHopsEntity warehouseNextHopsEntity = mapper.warehouseNextHopsToWarehouseNextHopsEntity(warehouseNextHops);

        assertEquals(10, warehouseNextHopsEntity.getTravelTimeMinutes());
        assertNotNull(warehouseNextHopsEntity.getHop());
    }
}