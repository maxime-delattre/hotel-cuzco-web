package com.cuzco.hotel.application.usecases;

import com.cuzco.hotel.domain.model.Rooms;
import com.cuzco.hotel.infrastructure.repositories.RoomsJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRooms {

    private final RoomsJdbcRepository roomsRepository;

    @Autowired
    public GetRooms(RoomsJdbcRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public Rooms execute() {
        return roomsRepository.get();
    }

}
