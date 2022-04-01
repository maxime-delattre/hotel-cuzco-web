package com.cuzco.hotel.teste2e;

import com.cuzco.hotel.infrastructure.controllers.CreateRoomCommandApi;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;

public class AddRoomE2eTest extends E2eTest {

    @Test
    void givenCreateRoomCommandThenCreateRoom() throws JSONException {
        CreateRoomCommandApi requestBody = new CreateRoomCommandApi(
                103,
                1,
                "awesome room 3",
                5
        );

        // when then
        with().body(requestBody).when().post("http://localhost:" + port + "/rooms").then().statusCode(200);

        var body = when().get("http://localhost:" + port + "/rooms").then().extract().response().body().asString();

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
                                    },
                                    {
                                      "number": 103,
                                      "etage": 1,
                                      "description": "awesome room 3",
                                      "capacite": 5
                                    }
                                  ]
                                }
                                
                """;


        JSONAssert.assertEquals(expectedBody, body, true);
    }


}
