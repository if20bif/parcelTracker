package at.fhtw.swen3.services.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

@Component
@Slf4j
public class ObjectValidator {

    private static ObjectValidator instance;

    private Validator validator;

    public static ObjectValidator getInstance(){
        if(instance == null)
            instance = new ObjectValidator();
        return instance;
    }

    private ObjectValidator(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public <T> void validate(T t){
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        violations.forEach(v -> log.error(v.getMessage()));

        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }
}
