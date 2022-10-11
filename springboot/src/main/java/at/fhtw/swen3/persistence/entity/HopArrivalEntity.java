package at.fhtw.swen3.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Entity
public class HopArrivalEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "fk_parcel")
    private ParcelEntity fk_parcel;


}
