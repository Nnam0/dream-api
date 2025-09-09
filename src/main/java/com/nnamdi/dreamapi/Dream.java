package com.nnamdi.dreamapi;

public class Dream {
    private String id;
    private String title;
    private String description;
    private String createdAt;

    // Getters and Setters (or use Lombok @Data if you added Lombok dependency)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
