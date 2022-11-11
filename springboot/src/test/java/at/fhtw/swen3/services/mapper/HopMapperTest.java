package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HopMapperTest {

    private HopMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new HopMapperImpl();
    }

    @Test
    void hopToHopEntity() {
        Hop hop = new Hop();

        hop.setHopType("TYPE");
        hop.setLocationName("LOCATION");
        hop.setDescription("DESC");
        hop.setCode("CODE");
        hop.setProcessingDelayMins(10);
        //hop.setLocationCoordinates(new GeoCoordinate());

        HopEntity hopEntity = mapper.hopToHopEntity(hop);

        assertTrue(hopEntity.getHopType().equals("TYPE"));
        assertTrue(hopEntity.getLocationName().equals("LOCATION"));
        assertTrue(hopEntity.getDescription().equals("DESC"));
        assertTrue(hopEntity.getCode().equals(("CODE")));
        assertEquals(10, hopEntity.getProcessingDelayMins());
        //assertNotNull(hopEntity.getLocationCoordinates());
    }

    @Test
    void hopEntityToHop() {
        HopEntity hopEntity = new HopEntity();

        hopEntity.setHopType("TYPE");
        hopEntity.setLocationName("LOCATION");
        hopEntity.setDescription("DESC");
        hopEntity.setCode("CODE");
        hopEntity.setProcessingDelayMins(10);
        //hopEntity.setLocationCoordinates();

        Hop hop = mapper.hopEntityToHop(hopEntity);

        assertTrue(hop.getHopType().equals("TYPE"));
        assertTrue(hop.getLocationName().equals("LOCATION"));
        assertTrue(hop.getDescription().equals("DESC"));
        assertTrue(hop.getCode().equals(("CODE")));
        assertEquals(10, hop.getProcessingDelayMins());
        //assertNotNull(hop.getLocationCoordinates());
    }
}