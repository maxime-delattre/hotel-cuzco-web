package com.cuzco.hotel.domain.model;

import com.cuzco.hotel.domain.model.commands.CreateRoomCommand;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;



@EqualsAndHashCode
@ToString
@Entity
public class Room {
    public static final String DEFAULT_DESCRIPTION = "très belle chambre";

    @Id
    private final Integer number;
    private final int etage;
    private final String description;
    private final int capacite;

    public Room() {
        number = 0;
        etage = 0;
        description = "";
        capacite = 0;
    }

    public Room(int number, int etage, String description, int capacite) {
        this.number = number;
        this.etage = etage;
        this.description = description;
        this.capacite = capacite;
    }

    public Room(CreateRoomCommand command) {
        this.number = command.number();
        this.etage = command.floorNumber();

        if (command.description() == null) {
            this.description = DEFAULT_DESCRIPTION;

        } else {
            this.description = command.description();
        }

        this.capacite = command.capacity();
    }

    public int getNumber() {
        return number;
    }

    public int getEtage() {
        return etage;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacite() {
        return capacite;
    }
}
