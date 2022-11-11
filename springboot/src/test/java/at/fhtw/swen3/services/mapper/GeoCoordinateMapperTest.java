package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GeoCoordinateMapperTest {

    private GeoCoordinateMapperImpl mapper;

    @BeforeAll
    public void setup(){
        mapper = new GeoCoordinateMapperImpl();
    }

    @Test
    void geoCoordinateEntityToGeoCoordinate() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();

        geoCoordinateEntity.setLat(1.0);
        geoCoordinateEntity.setLon(1.0);

        GeoCoordinate geoCoordinate = mapper.geoCoordinateEntityToGeoCoordinate(geoCoordinateEntity);

        assertEquals(1.0, geoCoordinate.getLat());
        assertEquals(1.0, geoCoordinate.getLon());
    }

    @Test
    void geoCoordinateToGeoCoordinateEntity() {
        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat(1.0);
        geoCoordinate.setLon(1.0);

        GeoCoordinateEntity geoCoordinateEntity = mapper.geoCoordinateToGeoCoordinateEntity(geoCoordinate);

        assertEquals(1.0, geoCoordinateEntity.getLat());
        assertEquals(1.0, geoCoordinateEntity.getLon());
    }
}