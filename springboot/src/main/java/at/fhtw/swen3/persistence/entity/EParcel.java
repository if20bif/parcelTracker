package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EParcel {

    //NewParcelInfo

    @JsonProperty("trackingId")
    private String trackingId;

    //Tracking information

    @JsonProperty("state")
    private TrackingInformation.StateEnum state;

    @JsonProperty("visitedHops")
    private List<HopArrival> visitedHops = new ArrayList<>();

    @JsonProperty("futureHops")
    private List<HopArrival> futureHops = new ArrayList<>();

    //Parcel

    @JsonProperty("weight")
    private Float weight;

    @JsonProperty("recipient")
    private Recipient recipient;

    @JsonProperty("sender")
    private Recipient sender;
}
