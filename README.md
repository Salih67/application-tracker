# Application Tracker

A full-stack web application for managing and tracking job applications.

## Motivation

When applying to multiple jobs, it can become difficult to keep track of companies,
positions and application statuses. This project provides a central place to manage
applications and their current progress.

## Current Features

- Create applications
- Edit applications
- Delete applications
- Track application status
- Backend validation
- Error handling for invalid requests and missing applications
- React-based user interface

## Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

### Frontend
- React
- TypeScript
- Vite
- CSS

## Project Status

Work in progress.

The Spring Boot REST API is implemented with CRUD operations, validation and error handling.
The React frontend currently supports creating, editing and deleting applications locally.

The next step is connecting the frontend to the REST API so that application data is persisted in PostgreSQL.

## Architecture

React Frontend
→ REST API
→ Spring Boot Backend
→ JPA / Hibernate
→ PostgreSQL

Additional diagrams can be found in:

`docs/diagrams/`

## Running the Project

### Backend

Set the following environment variables:

`DB_USERNAME`

`DB_PASSWORD`

Then run:

`cd backend`

`.\mvnw.cmd spring-boot:run`

The backend runs on:

`http://localhost:8080`

### Frontend

`cd frontend`

`npm install`

`npm run dev`

The frontend runs on:

`http://localhost:5173`