package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.dto.RatingDto;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.RatingAirplane;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CollateralAirplaneServiceImpl implements CollateralService {
    @Autowired
    private AirplaneService airplaneService;

    @Override
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }

        AirplaneDto airplaneDto = (AirplaneDto) object;
        boolean approved = airplaneService.approve(airplaneDto);
        if (!approved) {
            return null;
        }
        return Optional.of(airplaneDto)
                .map(airplaneService::fromDto)
                .map(airplaneService::save)
                .map(airplaneService::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(Collateral object) {
        if (!(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }

        return Optional.of((AirplaneDto) object)
                .map(airplaneService::fromDto)
                .map(airplaneService::getId)
                .flatMap(airplaneService::load)
                .map(airplaneService::toDTO)
                .orElse(null);
    }

    @Override
    public Collateral updateCollateral(Collateral object) {
        if (!(object instanceof AirplaneDto))
            throw new IllegalArgumentException();

        AirplaneDto airplaneDto = (AirplaneDto) object;

        Airplane airplane = airplaneService.load(airplaneDto.getId()).orElseThrow(NullPointerException::new);
        airplane.setYear(airplane.getYear());
//        boolean approved = airplaneService.approve(airplaneDto);
//
//        if (!approved)
//            return null;

        List<RatingAirplane> list = new ArrayList<>();
        for (RatingDto rd : airplaneDto.getRatingDto()) {
            list.add(new RatingAirplane(rd.getId(), rd.getValue(), rd.getDate(), airplane));
        }
        airplane.setList(list);
        airplaneService.save(airplane);

        return airplaneService.toDTO(airplane);
    }

}