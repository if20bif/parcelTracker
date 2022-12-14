package at.fhtw.swen3.services.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * WarehouseNextHops
 */

@JsonTypeName("warehouse_allOf_nextHops")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:14:49.172303Z[Etc/UTC]")
public class WarehouseNextHops {

  @JsonProperty("traveltimeMins")
  private Integer travelTimeMinutes;

  @JsonProperty("hop")
  private Hop hop;

  public WarehouseNextHops traveltimeMins(Integer traveltimeMins) {
    this.travelTimeMinutes = traveltimeMins;
    return this;
  }

  /**
   * Get traveltimeMins
   * @return traveltimeMins
  */
  @NotNull 
  @Schema(name = "traveltimeMins", required = true)
  public Integer getTravelTimeMinutes() {
    return travelTimeMinutes;
  }

  public void setTravelTimeMinutes(Integer travelTimeMinutes) {
    this.travelTimeMinutes = travelTimeMinutes;
  }

  public WarehouseNextHops hop(Hop hop) {
    this.hop = hop;
    return this;
  }

  /**
   * Get hop
   * @return hop
  */
  @NotNull @Valid 
  @Schema(name = "hop", required = true)
  public Hop getHop() {
    return hop;
  }

  public void setHop(Hop hop) {
    this.hop = hop;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WarehouseNextHops warehouseNextHops = (WarehouseNextHops) o;
    return Objects.equals(this.travelTimeMinutes, warehouseNextHops.travelTimeMinutes) &&
        Objects.equals(this.hop, warehouseNextHops.hop);
  }

  @Override
  public int hashCode() {
    return Objects.hash(travelTimeMinutes, hop);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WarehouseNextHops {\n");
    sb.append("    traveltimeMins: ").append(toIndentedString(travelTimeMinutes)).append("\n");
    sb.append("    hop: ").append(toIndentedString(hop)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

