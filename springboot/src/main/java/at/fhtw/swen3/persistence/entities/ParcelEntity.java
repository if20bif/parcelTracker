package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
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

    private String trackingId;

    //Tracking information

    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy = "parcel")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(mappedBy = "parcel")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    //Parcel

    private Float weight;

    @OneToOne
    @JoinColumn(name = "fk_recipient")
    private RecipientEntity recipient;

    @OneToOne
    @JoinColumn(name = "fk_sender")
    private RecipientEntity sender;
}
