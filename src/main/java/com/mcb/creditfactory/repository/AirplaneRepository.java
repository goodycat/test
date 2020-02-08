package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Airplane;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий для объекта самолёт.
 */
public interface AirplaneRepository extends CrudRepository<Airplane,Long> {

}