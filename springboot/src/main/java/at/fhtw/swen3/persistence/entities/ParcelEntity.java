package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "parcel")
public class ParcelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    //NewParcelInfo

    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

    //Tracking information
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy = "parcel")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(mappedBy = "parcel")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    //Parcel

    @Min(0)
    private Float weight;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_recipient")
    private RecipientEntity recipient;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_sender")
    private RecipientEntity sender;
}
