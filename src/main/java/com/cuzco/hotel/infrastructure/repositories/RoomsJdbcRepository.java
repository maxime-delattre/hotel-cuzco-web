package com.cuzco.hotel.infrastructure.repositories;

import com.cuzco.hotel.domain.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomsJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Rooms get() {
        return new Rooms(jdbcTemplate.query("SELECT * FROM room", new RoomRowMapper()));

    }
}
