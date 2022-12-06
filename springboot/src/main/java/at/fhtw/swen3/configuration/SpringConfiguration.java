package at.fhtw.swen3.configuration;

import at.fhtw.swen3.controller.rest.ParcelApiController;
import at.fhtw.swen3.controller.rest.WarehouseApiController;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.impl.ParcelService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseService;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.NativeWebRequest;

@Configuration
public class SpringConfiguration {

    @Bean
    public ParcelService parcelService(ParcelRepository parcelRepository){
        return new ParcelServiceImpl(parcelRepository);
    }

    @Bean
    public WarehouseService warehouseService(WarehouseRepository warehouseRepository){
        return new WarehouseServiceImpl(warehouseRepository);
    }

    /*@Bean
    public ParcelApiController parcelApiController(NativeWebRequest nativeWebRequest, ParcelService parcelService){
        return new ParcelApiController(nativeWebRequest, parcelService);
    }

    @Bean
    public WarehouseApiController warehouseApiController(NativeWebRequest nativeWebRequest, WarehouseService warehouseService){
        return new WarehouseApiController(nativeWebRequest, warehouseService);
    }*/

}
