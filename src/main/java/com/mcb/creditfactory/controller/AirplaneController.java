package com.mcb.creditfactory.controller;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Обработчик запросов пользователя для объекта обеспечения самолёт.
 */
@RestController
public class AirplaneController {
    /**
     * Внедрение сервиса для обработки запросов
     */
    @Qualifier("collateralAirplaneServiceImpl")
    @Autowired
    private CollateralService service;

    /**
     * POST-метод запроса для сохранения объекта.
     *
     * @param object объект самолёт.
     * @return первичный ключ сохранённого объекта.
     */
    @PostMapping("/airplane/save")
    public HttpEntity<Long> save(@RequestBody Collateral object) {
        Long id = service.saveCollateral(object);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    /**
     * POST-метод запроса для получения информации об объекте.
     *
     * @param object - объект самолёт.
     * @return - существующий объект в json-формате.
     */
    @PostMapping("/airplane/info")
    public HttpEntity<Collateral> info(@RequestBody Collateral object) {
        Collateral info = service.getInfo(object);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }

    /**
     * POST-метод запроса для добавления новой оценочной стоимости к объекту самолёт
     *
     * @param object - объект самолёт.
     * @return - json-объект автомобиль с добавленой оценочной стоимостью.
     */
    @PostMapping("/airplane")
    public HttpEntity<Collateral> addRating(@RequestBody Collateral object) {
        Collateral info = service.updateCollateral(object);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }
}