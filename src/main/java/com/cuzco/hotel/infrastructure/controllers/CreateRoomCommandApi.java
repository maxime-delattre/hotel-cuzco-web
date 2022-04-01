package com.cuzco.hotel.infrastructure.controllers;

public record CreateRoomCommandApi(int number, int floorNumber, String description, int capacity) {
}
