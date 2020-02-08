package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.dto.RatingDto;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.RatingCar;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CollateralCarServiceImpl implements CollateralService {
    @Autowired
    private CarService carService;

    @Override
    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof CarDto)) {
            throw new IllegalArgumentException();
        }

        CarDto car = (CarDto) object;
        boolean approved = carService.approve(car);
        if (!approved) {
            return null;
        }

        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::save)
                .map(carService::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(Collateral object) {
        if (!(object instanceof CarDto)) {
            throw new IllegalArgumentException();
        }

        return Optional.of((CarDto) object)
                .map(carService::fromDto)
                .map(carService::getId)
                .flatMap(carService::loadCarWithAllAccessedValues)
                .map(carService::toDTO)
                .orElse(null);
    }


    @Override
    public Collateral updateCollateral(Collateral object) {
        if (!(object instanceof CarDto))
            throw new IllegalArgumentException();

        CarDto carDto = (CarDto) object;

        Car car = carService.load(carDto.getId()).orElseThrow(NullPointerException::new);
        carDto.setYear(car.getYear());
        boolean approved = carService.approve(carDto);

        if (!approved)
            return null;

        List<RatingCar> list = new ArrayList<>();
        for (RatingDto rd : carDto.getRatingDto()) {
            list.add(new RatingCar(rd.getId(), rd.getValue(), rd.getDate(), car));
        }
        car.setCarSet(list);
        carService.save(car);

        return carService.toDTO(car);
    }
}