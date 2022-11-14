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
@Entity(name = "truck")
public class TruckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    private String regionGeoJson;

    private String numberPlate;

}
