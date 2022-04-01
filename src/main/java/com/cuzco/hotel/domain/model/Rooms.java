package com.cuzco.hotel.domain.model;

import java.util.List;

public class Rooms {
    List<Room> rooms;

    public Rooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
