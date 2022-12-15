package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
