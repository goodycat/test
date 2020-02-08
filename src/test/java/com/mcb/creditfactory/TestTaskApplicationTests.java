package com.mcb.creditfactory;

import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.RatingCar;
import com.mcb.creditfactory.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTaskApplicationTests {
    @Autowired
    private CarRepository carRepository;



    @Test
    public void contextLoads() {
    }

    @Test
    public void save() {
        Car car = new Car(
                0L,
                "bmw",
                "f30",
                194.0,
                (short) 2010
        );
        car.getCarSet().add(new RatingCar(0L, new BigDecimal(1500000), new Date(), car));
        Car saveCar =  carRepository.save(car);

    }
}