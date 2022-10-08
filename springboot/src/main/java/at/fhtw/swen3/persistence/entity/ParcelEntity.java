package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParcelEntity {

    //NewParcelInfo

    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private String trackingId;

    //Tracking information

    @Column
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy = "Parcel")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(mappedBy = "Parcel")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    //Parcel

    @Column
    private Float weight;

    @OneToOne
    @JoinColumn(name = "fk_recipient")
    private RecipientEntity recipient;

    @OneToOne
    @JoinColumn(name = "fk_sender")
    private RecipientEntity sender;
}
