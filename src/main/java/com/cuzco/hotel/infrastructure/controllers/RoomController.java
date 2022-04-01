package com.cuzco.hotel.infrastructure.controllers;

import com.cuzco.hotel.application.usecases.GetRooms;
import com.cuzco.hotel.domain.model.Rooms;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@Tag(name = "room", description = "the Room API")
public class RoomController {

    private final GetRooms getRooms;

    @Autowired
    public RoomController(GetRooms getRooms) {
        this.getRooms = getRooms;
    }

    @GetMapping
    @Operation(summary = "Find rooms", description = "Find rooms", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Rooms.class)))
    })
    public ResponseEntity<Rooms> getRooms() {
        return ResponseEntity.ok().body(getRooms.execute());
    }

}
