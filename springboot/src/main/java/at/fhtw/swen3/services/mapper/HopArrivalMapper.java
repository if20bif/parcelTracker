package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HopArrivalMapper {
    HopArrivalEntity hopArrivalToHopArrivalEntity (HopArrival hopArrival);
    HopArrival hopArrivalEntityToHopArrival (HopArrivalEntity hopArrivalEntity);

    List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> hopArrivalEntityList);
    List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> hopArrivalEntity);
}
