package at.fhtw.swen3;

import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.service.impl.OSMEncodingProxy;
import com.fasterxml.jackson.databind.Module;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.lang.model.util.Elements;

@SpringBootApplication
@ComponentScan(basePackages = {"at.fhtw.swen3", "at.fhtw.swen3.services" , "at.fhtw.swen3.configuration", "at.fhtw.swen3.controller.rest"})
@EnableJpaRepositories(basePackages = "at.fhtw.swen3.persistence.repositories")
@EntityScan(basePackages = "at.fhtw.swen3.persistence.entities")
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Bean
    CommandLineRunner commandLineRunner(/*RecipientRepository recipientRepository*//*OSMEncodingProxy osmEncodingProxy*/){
        return args -> {
            //recipientRepository.save(new RecipientEntity(null, "Jane Doe", "Kärntnerstraße 1", "1010", "Vienna", "Austria"));
            //osmEncodingProxy.decodeAddress()

            GeometryFactory geometryFactory = new GeometryFactory();
            Coordinate coords = new Coordinate(16.333361758251698, 48.23603769206206);
            Point point = geometryFactory.createPoint(coords);

            OSMEncodingProxy proxy = new OSMEncodingProxy();

            String address = proxy.decodeAddress(point);

            System.out.println(address);

            Point result = proxy.encodeAddress(address);

            System.out.println(result.getX());
            System.out.println(result.getY());
        };
    }

}