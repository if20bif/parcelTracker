package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;

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

    private String name;

    private String street;

    private String postalCode;

    private String city;

    private String country;
}
