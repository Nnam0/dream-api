package com.nnamdi.dreamapi;

import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/api/v1/dreams")
public class DreamController {

    private final List<Dream> dreams = new ArrayList<>();

    // POST endpoint to add a dream
    @PostMapping
    public Dream addDream(@RequestBody Dream dream) {
        dream.setId(UUID.randomUUID().toString());
        dream.setCreatedAt(Instant.now().toString());
        dreams.add(dream);
        return dream;
    }

    // GET endpoint to fetch all dreams
    @GetMapping
    public List<Dream> getDreams() {
        return dreams;
    }
}
