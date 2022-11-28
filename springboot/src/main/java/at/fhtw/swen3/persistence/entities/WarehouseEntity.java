package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Hop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WarehouseEntity extends HopEntity {

    private Integer level;

    @OneToMany(mappedBy = "warehouse")
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
