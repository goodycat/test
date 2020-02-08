package com.mcb.creditfactory.controller;

import com.mcb.creditfactory.dto.Collateral;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
@ActiveProfiles("test")
public class CollateralObjectControllerTest {
    @LocalServerPort
    private int port;

    private String json = "{\n" +
            "  \"type\": \"car\",\n" +
            "  \"id\": \"0\",\n" +
            "  \"brand\": \"bmw\",\n" +
            "  \"model\": \"f30\",\n" +
            "  \"power\": \"194.0\",\n" +
            "  \"year\": \"2014\",\n" +
            "  \"rating\": [\n" +
            "    {\n" +
            "      \"id\": \"0\",\n" +
            "      \"value\": \"900000\",\n" +
            "      \"date\": \"2017-09-10\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"0\",\n" +
            "      \"value\": \"1100000\",\n" +
            "      \"date\": \"2017-10-10\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void save() throws Exception {
        ResponseEntity<Collateral> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/collateral/save").toString(), json, Collateral.class);
        System.out.println(response);
    }


    @Test
    public void getInfo() {
    }
}