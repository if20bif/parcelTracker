package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String code;

    private String description;

    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "parcel")
    private ParcelEntity parcel;

}
