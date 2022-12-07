package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hop_arrival")
public class HopArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;

    @Pattern(regexp = "[A-Za-z0-9- ]+")
    private String description;

    @NotNull
    private OffsetDateTime dateTime;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "parcel")
    private ParcelEntity parcel;

}
