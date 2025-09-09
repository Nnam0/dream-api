package com.nnamdi.dreamapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DreamApiIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/v1/dreams";
    }

    @Test
    void testPostAndGetDreams() {
        // Create a dream
        Dream newDream = new Dream();
        newDream.setTitle("Become a Software Engineer");
        newDream.setDescription("I want to build amazing projects.");

        ResponseEntity<Dream> postResponse = restTemplate.postForEntity(
                getBaseUrl(),
                newDream,
                Dream.class
        );

        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody()).isNotNull();
        assertThat(postResponse.getBody().getId()).isNotNull();
        assertThat(postResponse.getBody().getTitle()).isEqualTo("Become a Software Engineer");

        // Fetch all dreams
        ResponseEntity<Dream[]> getResponse = restTemplate.getForEntity(
                getBaseUrl(),
                Dream[].class
        );

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody()).isNotNull();
        assertThat(getResponse.getBody().length).isGreaterThan(0);
    }
}
