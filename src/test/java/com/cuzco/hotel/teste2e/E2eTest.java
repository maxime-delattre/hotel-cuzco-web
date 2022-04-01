package com.cuzco.hotel.teste2e;

import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class E2eTest {

    public static final String POSTGRES_USERNAME = "hotelcuzco";
    public static final String POSTGRES_PASSWORD = "password";
    public static final String DATABASE_NAME = POSTGRES_USERNAME;
    public static final int POSTGRES_PORT = 5432;

    // easier way in RoomJpaRepositoryIntegrationTest.java
    @Container
    public static GenericContainer postgres = new GenericContainer(DockerImageName.parse("postgres:13.2"))
            .withEnv("POSTGRES_PASSWORD", POSTGRES_PASSWORD)
            .withEnv("POSTGRES_USER", POSTGRES_USERNAME)
            .withExposedPorts(POSTGRES_PORT);

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> "jdbc:postgresql://" + postgres.getHost() + ":" + postgres.getMappedPort(5432) + "/" + DATABASE_NAME);
        registry.add("spring.datasource.username", () -> POSTGRES_USERNAME);
        registry.add("spring.datasource.password", () -> POSTGRES_PASSWORD);
    }

    @LocalServerPort
    protected Integer port;

    @AfterEach
    private void cleanDatabase() {
        // TODO : a way to clean database after each test
    }
}
