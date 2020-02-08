package com.mcb.creditfactory.repository.impl;

import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.CarRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.Optional;

/**
 * Опционный репозиторий для дополнительных запросов.
 */
@Transactional
public abstract class CarRepositoryImpl implements CarRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Метод находит все оценочные стоимости объекта автомобиль по первичному ключу автомобиля.
     *
     * @param id - первичный ключ.
     * @return - возможный найденый объект автомобиль с оценочными стоимостями.
     */
    @Override
    public Optional<Car> findAllAccessedValuesById(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> ccq = cb.createQuery(Car.class);
        Root<Car> rc = ccq.from(Car.class);
        rc.fetch("carSet", JoinType.LEFT);
        ccq.select(rc)
                .where(
                        cb.equal(rc.get("id"), id)
                );
        return Optional.of(entityManager.createQuery(ccq).getSingleResult());
    }
}