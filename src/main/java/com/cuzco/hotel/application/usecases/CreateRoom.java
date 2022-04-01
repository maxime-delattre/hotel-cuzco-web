package com.cuzco.hotel.application.usecases;

import com.cuzco.hotel.domain.model.Room;
import com.cuzco.hotel.domain.model.commands.CreateRoomCommand;
import com.cuzco.hotel.infrastructure.repositories.RoomJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRoom {

    private final RoomJpaRepository roomJpaRepository;

    @Autowired
    public CreateRoom(RoomJpaRepository roomJpaRepository) {
        this.roomJpaRepository = roomJpaRepository;
    }

    public void execute(CreateRoomCommand command) {
        var room = new Room(command);
        roomJpaRepository.save(room);
    }

}
