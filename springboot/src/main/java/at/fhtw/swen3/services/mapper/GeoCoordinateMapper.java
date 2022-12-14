package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;

@Mapper
public interface GeoCoordinateMapper {
    GeoCoordinate geoCoordinateEntityToGeoCoordinate(GeoCoordinateEntity geoCoordinateEntity);
    GeoCoordinateEntity geoCoordinateToGeoCoordinateEntity(GeoCoordinate geoCoordinate);
}
