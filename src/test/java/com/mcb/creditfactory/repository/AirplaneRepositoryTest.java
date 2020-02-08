package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.RatingAirplane;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirplaneRepositoryTest {
    @Autowired
    private AirplaneRepository airplaneRepository;

    @Test
    public void save() {
        Airplane airplane = new Airplane(0L, "f35", "test", "rus", (short) 2014,5000,2);
        airplane.getList().add(new RatingAirplane(0L, new BigDecimal(240000000), new Date(),airplane));

        Airplane saveAirplane = airplaneRepository.save(airplane);
        Assert.assertNotNull(saveAirplane.getId());
        Assert.assertEquals(new Long(1), saveAirplane.getId());
    }
}