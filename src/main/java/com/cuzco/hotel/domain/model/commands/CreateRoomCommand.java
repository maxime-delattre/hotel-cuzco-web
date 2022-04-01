package com.cuzco.hotel.domain.model.commands;

public record CreateRoomCommand(int number, int floorNumber, String description, int capacity) {
}
