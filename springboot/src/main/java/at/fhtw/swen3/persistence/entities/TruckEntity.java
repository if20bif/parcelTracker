package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Hop;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TruckEntity extends HopEntity {

    private String regionGeoJson;

    private String numberPlate;

}
