package com.cuzco.hotel.teste2e;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static io.restassured.RestAssured.when;

public class GetRoomsE2eTest extends E2eTest {

    @Test
    void givenCreateRoomCommandThenCreateRoom() throws JSONException {
        var body = when().get("http://localhost:" + port + "/rooms").then().statusCode(200)
                .extract().response().body().asString();

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
