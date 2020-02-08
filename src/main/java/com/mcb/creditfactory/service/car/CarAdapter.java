package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.RatingDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {
    private CarDto car;

    @Override
    public BigDecimal getValue() {
        return getLatestRating().getValue();
    }

    private RatingDto getLatestRating() {
        return car.getRatingDto().stream().max(Comparator.comparing(RatingDto::getDate)).orElse(null);
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        return getLatestRating().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
