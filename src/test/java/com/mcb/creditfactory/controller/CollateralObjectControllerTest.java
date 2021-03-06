package com.mcb.creditfactory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.RatingDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CollateralObjectControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void save() throws Exception {
        List<RatingDto> list = new ArrayList<>();
        list.add(new RatingDto(0L, new BigDecimal(1100000), new Date()));
        CarDto carDto = new CarDto(0L, "bmw", "f30", 194.0, (short) 2014, list);

        ObjectMapper om = new ObjectMapper();
        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(carDto);
        System.out.println(json);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> collateralHttpEntity = new HttpEntity<>(json, headers);


        ResponseEntity<String> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/collateral/save").toString(), collateralHttpEntity, String.class);
        Assert.assertEquals(1L, Integer.parseInt(Objects.requireNonNull(response.getBody())));
    }
}