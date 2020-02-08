package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Общий контракт для объектов data transfer object.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDto.class),
        @JsonSubTypes.Type(value = AirplaneDto.class)
})
public interface Collateral {
}
