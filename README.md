# 🌙 Dream API

A simple REST API built with Spring Boot to manage dreams.  
It allows users to **create new dreams** and **fetch all saved dreams**.  
Dreams are stored in an **in-memory list** (no database required).

---

## Features
  - POST /api/v1/dreams → Save a dream
  - GET /api/v1/dreams → Retrieve all dreams

## Tech Stack
  - Spring boot 3
  - Java 21
  - Maven
  - Jacoco
  - Github actions

## How to Use
Run the application:
```bash
mvn spring-boot:run
🔗 How the API Works

The API exposes endpoints to:

POST → Add a new dream
GET → Fetch all dreams

Each dream contains:
id (auto-generated)
title
description
curl -X POST http://localhost:8080/api/v1/dreams \
  -H "Content-Type: application/json" \
  -d '{"title": "Become a Software Engineer", "description": "I want to build amazing projects."}'
