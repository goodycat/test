package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.RatingDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.RatingCar;
import com.mcb.creditfactory.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private CarRepository carRepository;

    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto)) == 0;
    }

    @Override
    public Optional<Car> loadCarWithAllAccessedValues(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto) {
        Car car = new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear()
        );
        for (RatingDto rd :
                dto.getRatingDto()) {
            RatingCar rc = new RatingCar(rd.getId(),rd.getValue(),rd.getDate(),car);
            car.getCarSet().add(rc);
        }
        return car;
    }


    @Override
    public CarDto toDTO(Car car) {
        List<RatingDto> list = new ArrayList<>();
        for (RatingCar rc :
                car.getCarSet()) {
            RatingDto dto = new RatingDto(rc.getId(), rc.getValue(), rc.getDate());
            list.add(dto);
        }

        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear(), list
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }

}