package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;
import org.springframework.stereotype.Service;


/**
 * Сервис для работы со вспомогательными объектами (обёртка).
 */
@Service
public interface CollateralService {

    /**
     * Метод сохраняет вспомогательный объект.
     *
     * @param object - вспомогательный объект.
     * @return - первичный ключ.
     */
    Long saveCollateral(Collateral object);

    /**
     * Мето предоставляет информацию по объекту обеспечения.
     *
     * @param object - вспомогательный объект.
     * @return - вспомогательный объект.
     */
    Collateral getInfo(Collateral object);

    /**
     * Метод обновляет объект обеспечения.
     *
     * @param object - вспомогательный объект.
     * @return - вспомогательный объект.
     */
    Collateral updateCollateral(Collateral object);
}