package at.fhtw.swen3;

import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.persistence.repository.RecipientRepository;
import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"at.fhtw.swen3", "at.fhtw.swen3.services" , "at.fhtw.swen3.configuration"})
@EnableJpaRepositories(basePackages = "at.fhtw.swen3.persistence.repository")
@EntityScan(basePackages = "at.fhtw.swen3.persistence.entity")
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Bean
    CommandLineRunner commandLineRunner(RecipientRepository recipientRepository){
        return args -> {
            recipientRepository.save(new RecipientEntity(null, "Jane Doe", "Kärntnerstraße 1", "1010", "Vienna", "Austria"));
        };
    }

}