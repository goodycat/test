package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data transfer object для объекта самолёт.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private int fuelCapacity;
    private int seats;
    @JsonProperty("rating")
    private List<RatingDto> ratingDto;
}