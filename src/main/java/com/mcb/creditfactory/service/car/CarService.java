package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.service.GenericService;

import java.util.Optional;

public interface CarService extends GenericService<CarDto,Car> {
    Optional<Car> loadCarWithAllAccessedValues(Long id);
}