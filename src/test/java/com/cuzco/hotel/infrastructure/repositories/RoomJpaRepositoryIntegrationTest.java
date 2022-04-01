package com.cuzco.hotel.infrastructure.repositories;

import com.cuzco.hotel.domain.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class RoomJpaRepositoryIntegrationTest {

    public static final String POSTGRES_USERNAME = "hotelcuzco";
    public static final String POSTGRES_PASSWORD = "password";
    public static final String DATABASE_NAME = POSTGRES_USERNAME;

    @Container
    public static PostgreSQLContainer<?> postgresDB = new PostgreSQLContainer<>
            ("postgres:13.2")
            .withDatabaseName(DATABASE_NAME)
            .withUsername(POSTGRES_USERNAME)
            .withPassword(POSTGRES_PASSWORD);

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresDB::getJdbcUrl);
        registry.add("spring.datasource.username", postgresDB::getUsername);
        registry.add("spring.datasource.password", postgresDB::getPassword);
    }

    private final RoomJpaRepository roomJpaRepository;

    @Autowired
    RoomJpaRepositoryIntegrationTest(RoomJpaRepository roomJpaRepository) {
        this.roomJpaRepository = roomJpaRepository;
    }

    @Test
    void givenRoomThenSave() throws Exception {
        // given
        Room room = new Room(103, 4, "awesome room", 3);

        // when
        roomJpaRepository.save(room);

        // then
        assertThat(room).isEqualTo(roomJpaRepository.findById(103).orElseThrow(Exception::new));
    }

}