package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.Mapper;
import at.fhtw.swen3.services.mapper.ParcelMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.Arrays;
import java.util.Set;

@Service
@Slf4j
public class ParcelService {

    @Autowired
    private ParcelMapStruct parcelMapStruct;

    public void savePostalCode(@Valid Recipient recipient){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Recipient>> violations = validator.validate(recipient);
        for (ConstraintViolation<Recipient> violation : violations) {
            if (recipient.getCountry().equals("Österreich") || recipient.getCountry().equals("Austria"))
            {
                log.error(violation.getMessage());
            }

           if(!Arrays.asList("postalCode", "street", "name", "city").contains(String.valueOf(violation.getPropertyPath()))){
               log.error(violation.getMessage());
           }
        }
    }
}
