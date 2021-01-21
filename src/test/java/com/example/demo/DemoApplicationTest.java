package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTest {
    private static final String HOST = "http://192.168.99.100:";

    private static final String DEV_APP_IMAGE = "devapp";
    private static final int DEV_APP_PORT = 8080;
    private static final String PROD_APP_IMAGE = "prodapp";
    private static final int PROD_APP_PORT = 8081;
    private static final String ENDPOINT = "/profile";

    private static final String RESULT_DEV = "Current profile is Development";
    private static final String RESULT_PROD = "Current profile is Production";

    @Autowired
    TestRestTemplate restTemplate;

    public static GenericContainer<?> devApp = new GenericContainer<>(DEV_APP_IMAGE).withExposedPorts(DEV_APP_PORT);
    public static GenericContainer<?> prodApp = new GenericContainer<>(PROD_APP_IMAGE).withExposedPorts(PROD_APP_PORT);

    @BeforeAll
    public static void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void devAppTest() {
        ResponseEntity<String> testEntity = restTemplate.getForEntity(HOST + devApp.getMappedPort(DEV_APP_PORT) +
                ENDPOINT, String.class);
        Assertions.assertEquals(RESULT_DEV,testEntity.getBody());
    }

    @Test
    void prodAppTest() {
        ResponseEntity<String> testEntity = restTemplate.getForEntity(HOST + prodApp.getMappedPort(PROD_APP_PORT) +
                ENDPOINT, String.class);
        Assertions.assertEquals(RESULT_PROD,testEntity.getBody());
    }
}

