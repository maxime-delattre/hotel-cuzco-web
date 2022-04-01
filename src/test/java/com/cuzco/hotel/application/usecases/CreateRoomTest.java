package com.cuzco.hotel.application.usecases;

import com.cuzco.hotel.domain.model.Room;
import com.cuzco.hotel.domain.model.commands.CreateRoomCommand;
import com.cuzco.hotel.infrastructure.repositories.RoomJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateRoomTest {

    @InjectMocks
    private CreateRoom createRoom;

    @Mock
    private RoomJpaRepository roomJpaRepository;

    @Test
    void givenCreateRoomCommandThenCreateRoomAndPersistIt() {
    	// given
        CreateRoomCommand command = new CreateRoomCommand(1, 101, "awesome room", 3);

        // when
        createRoom.execute(command);

    	// then
        Room roomExpected = new Room(1, 101, "awesome room", 3);

        verify(roomJpaRepository).save(roomExpected);
    }

}