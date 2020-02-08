package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;

import java.util.Optional;

/**
 * Обобщённый сервис для объектов обеспечения.
 * @param <E> - тип, ограниченный вспомогательным объектом.
 * @param <T> - объект обеспечения.
 */
public interface GenericService<E extends Collateral,T> {
    /**
     * Метод выполняет операции для утверждения необходимых условий.
     *
     * @param object - вспомогательный объект.
     * @return - логический ответ.
     */
    boolean approve(E object);

    /**
     * Метод сохраняет сущность.
     *
     * @param entity - сохраняемая сущность.
     * @return - сохранённую сущность.
     */
    T save(T entity);

    /**
     * Метод загружает сущность.
     *
     * @param id - первичный ключ.
     * @return - возможно найденную сущность.
     */
    Optional<T> load(Long id);

    /**
     * Перенос данных из вспомогательного объекта в сущность.
     *
     * @param object - вспомогательный объект.
     * @return - сущность.
     */
    T fromDto(E object);

    /**
     * Перенос данных из сущности в вспомогательный объект.
     *
     * @param entity - сущность.
     * @return - вспомогательный объект.
     */
    E toDTO(T entity);

    /**
     * Метод возвращает первичный ключ у сущности.
     *
     * @param entity - сущность.
     * @return - первичный ключ.
     */
    Long getId(T entity);
}