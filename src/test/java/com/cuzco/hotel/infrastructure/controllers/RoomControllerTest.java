package com.cuzco.hotel.infrastructure.controllers;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.when;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
class RoomControllerTest {

    @Test
    void returns200AndRoomList() throws JSONException {
        var body = when().get("http://localhost:8080/rooms").then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .asString();

        log.info(body);

        String expectedBody = """
                {
                  "rooms": [
                    {
                      "number": 101,
                      "etage": 1,
                      "description": "belle chambre",
                      "capacite": 2
                    },
                    {
                      "number": 102,
                      "etage": 2,
                      "description": "belle chambre",
                      "capacite": 3
                    }
                  ]
                }
                """;

        JSONAssert.assertEquals(expectedBody, body, true);
    }
}