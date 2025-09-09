package com.nnamdi.dreamapi;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DreamControllerTest {

    private final DreamController dreamController = new DreamController();
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(dreamController).build();

    @Test
    void testAddDream() throws Exception {
        String dreamJson = """
                {
                  "title": "Fly in Space",
                  "description": "I dreamed I was flying among the stars."
                }
                """;

        mockMvc.perform(post("/api/v1/dreams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dreamJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("Fly in Space"))
                .andExpect(jsonPath("$.description").value("I dreamed I was flying among the stars."))
                .andExpect(jsonPath("$.createdAt").exists());
    }

    @Test
    void testGetDreams() throws Exception {
        // First, add a dream
        String dreamJson = """
                {
                  "title": "Test Dream",
                  "description": "This is only a test."
                }
                """;

        mockMvc.perform(post("/api/v1/dreams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dreamJson))
                .andExpect(status().isOk());

        // Then check the list endpoint
        mockMvc.perform(get("/api/v1/dreams"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}
