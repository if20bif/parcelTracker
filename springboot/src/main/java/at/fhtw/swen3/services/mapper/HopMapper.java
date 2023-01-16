package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(HopMapperDecorator.class)
public interface HopMapper {
    HopEntity hopToHopEntity (Hop hop);
    Hop hopEntityToHop (HopEntity hopEntity);


}
