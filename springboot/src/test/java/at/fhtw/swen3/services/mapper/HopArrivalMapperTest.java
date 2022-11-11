package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.OffsetDateTime;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HopArrivalMapperTest {

    private HopArrivalMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new HopArrivalMapperImpl();
    }

    @Test
    void hopArrivalToHopArrivalEntity() {
        HopArrival hopArrival = new HopArrival();

        hopArrival.setCode("TEST1234");
        hopArrival.setDescription("Warehouse 12-27");
        hopArrival.setDateTime(OffsetDateTime.MIN);

        HopArrivalEntity hopArrivalEntity = mapper.hopArrivalToHopArrivalEntity(hopArrival);

        assertTrue(hopArrivalEntity.getCode().equals("TEST1234"));
        assertTrue(hopArrivalEntity.getDescription().equals("Warehouse 12-27"));
        assertEquals(hopArrivalEntity.getDateTime(), OffsetDateTime.MIN);
    }

    @Test
    void hopArrivalEntityToHopArrival() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();

        hopArrivalEntity.setCode("TEST1234");
        hopArrivalEntity.setDescription("Warehouse 12-27");
        hopArrivalEntity.setDateTime(OffsetDateTime.MIN);

        HopArrival hopArrival = mapper.hopArrivalEntityToHopArrival(hopArrivalEntity);

        assertTrue(hopArrival.getCode().equals("TEST1234"));
        assertTrue(hopArrival.getDescription().equals("Warehouse 12-27"));
        assertEquals(hopArrival.getDateTime(), OffsetDateTime.MIN);
    }
}