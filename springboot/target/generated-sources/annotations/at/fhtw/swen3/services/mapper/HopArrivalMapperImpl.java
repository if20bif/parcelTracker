package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity.HopArrivalEntityBuilder;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.HopArrival.HopArrivalBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-11T18:05:23+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class HopArrivalMapperImpl implements HopArrivalMapper {

    @Override
    public HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntityBuilder hopArrivalEntity = HopArrivalEntity.builder();

        hopArrivalEntity.code( hopArrival.getCode() );
        hopArrivalEntity.description( hopArrival.getDescription() );
        hopArrivalEntity.dateTime( hopArrival.getDateTime() );

        return hopArrivalEntity.build();
    }

    @Override
    public HopArrival hopArrivalEntityToHopArrival(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrivalBuilder hopArrival = HopArrival.builder();

        hopArrival.code( hopArrivalEntity.getCode() );
        hopArrival.description( hopArrivalEntity.getDescription() );
        hopArrival.dateTime( hopArrivalEntity.getDateTime() );

        return hopArrival.build();
    }

    @Override
    public List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> hopArrivalEntityList) {
        if ( hopArrivalEntityList == null ) {
            return null;
        }

        List<HopArrival> list = new ArrayList<HopArrival>( hopArrivalEntityList.size() );
        for ( HopArrivalEntity hopArrivalEntity : hopArrivalEntityList ) {
            list.add( hopArrivalEntityToHopArrival( hopArrivalEntity ) );
        }

        return list;
    }

    @Override
    public List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        List<HopArrivalEntity> list = new ArrayList<HopArrivalEntity>( hopArrivalEntity.size() );
        for ( HopArrival hopArrival : hopArrivalEntity ) {
            list.add( hopArrivalToHopArrivalEntity( hopArrival ) );
        }

        return list;
    }
}
