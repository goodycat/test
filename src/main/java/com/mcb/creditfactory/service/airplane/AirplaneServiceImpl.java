package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.RatingDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.RatingAirplane;
import com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private ExternalApproveService approveService;

    @Override
    public boolean approve(AirplaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto) {
        Airplane airplane = new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getYear(),
                dto.getFuelCapacity(),
                dto.getSeats()
        );
        for (RatingDto rd :
                dto.getRatingDto()) {
            RatingAirplane rc = new RatingAirplane(rd.getId(), rd.getValue(), rd.getDate(), airplane);
            airplane.getList().add(rc);
        }
        return airplane;
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        List<RatingDto> list = new ArrayList<>();
        for (RatingAirplane rc :
                airplane.getList()) {
            RatingDto dto = new RatingDto(rc.getId(), rc.getValue(), rc.getDate());
            list.add(dto);
        }
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getYear(),
                airplane.getFuelCapacity(),
                airplane.getSeats(), list
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}