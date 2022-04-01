package com.cuzco.hotel.domain.model;

import com.cuzco.hotel.domain.model.commands.CreateRoomCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoomTest {

    @Test
    void givenCreateRoomCommandThenCreateRoom() {
    	// given
        CreateRoomCommand command = new CreateRoomCommand(101, 1, "awesome room", 3);

        // when
        Room roomObtained = new Room(command);

        // then
        Room roomExpected = new Room(101, 1, "awesome room", 3);
        assertThat(roomObtained).isEqualTo(roomExpected);
    }

    @Test
    void givenNoDescriptionThenRoomIsCreatedWithDefaultDescription() {
        // given
        CreateRoomCommand command = new CreateRoomCommand(101, 1, null, 3);

        // when
        Room roomObtained = new Room(command);

        // then
        Room roomExpected = new Room(101, 1, "très belle chambre", 3);
        assertThat(roomObtained).isEqualTo(roomExpected);
    }



}