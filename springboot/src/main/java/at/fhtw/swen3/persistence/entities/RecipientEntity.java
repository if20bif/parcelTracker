package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipient")
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    @Pattern(regexp = "[A-Z][A-Za-z0-9- ]*")
    private String name;

    @Pattern(regexp = "[A-Zßa-z]+ [0-9]+[0-9a-z/]*")
    private String street;

    @Pattern(regexp = "A-[0-9]{4}")
    private String postalCode;

    @Pattern(regexp = "[A-Z][A-Za-z0-9- ]*")
    private String city;

    @Pattern(regexp = "[A-Za-zöÖüÜäÄåç]+")
    private String country;
}
