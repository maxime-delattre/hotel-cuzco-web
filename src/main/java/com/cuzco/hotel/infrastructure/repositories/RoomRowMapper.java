package com.cuzco.hotel.infrastructure.repositories;

import com.cuzco.hotel.domain.model.Room;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Room(
                rs.getInt("number"),
                rs.getInt("etage"),
                rs.getString("description"),
                rs.getInt("capacite")
        );
    }

}
