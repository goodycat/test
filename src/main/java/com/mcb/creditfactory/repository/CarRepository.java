package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Репозиторий для объекта автомобиль.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
    /**
     * Метод находит все оценочные стоимости объекта автомобиль по первичному ключу автомобиля.
     * @param id - первичный ключ.
     * @return - возможный найденый объект автомобиль с оценочными стоимостями.
     */
    Optional<Car> findAllAccessedValuesById(Long id);
}
