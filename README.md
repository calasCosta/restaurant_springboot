# Restaurant Menu Manager – Spring Boot Tutorial Project

A hands‑on, project‑based tutorial teaching Spring Boot 3.2+ by building a real‑world **Restaurant Menu Manager** API.  
Currently covers CRUD, JPA persistence, layered architecture, validation, and global exception handling.  
More features (security, file upload, async, testing, Docker) will be added as the tutorial evolves.

## Tech Stack

- Java 17
- Spring Boot 3.2+
- Spring Web MVC
- Spring Data JPA (Hibernate)
- H2 Database (in‑memory, for development)
- Jakarta Bean Validation
- Maven
- curl for testing

## What's Implemented So Far

- Full CRUD endpoints for `MenuItem`:
  - `GET /items` – list all
  - `GET /items/{id}` – get one
  - `POST /items` – create
  - `PUT /items/{id}` – update
  - `DELETE /items/{id}` – delete
- Clean layered architecture: `presentation` (controller), `service` (business logic), `persistence` (entity + repository)
- JPA entity with database‑generated ID (`@GeneratedValue`)
- Validation constraints (`@NotBlank`, `@Positive`) triggered with `@Valid`
- Global exception handler (`@RestControllerAdvice`) returning clean JSON for:
  - HTTP 400 – validation errors (field‑specific messages)
  - HTTP 404 – custom `ResourceNotFoundException`

## Testing the API

After running the application, use `curl` (or any REST client). Example commands:

```bash
# Create a menu item
curl -X POST http://localhost:8080/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Margherita Pizza","price":12.5}'

# Get all items
curl http://localhost:8080/items

# Get one item
curl http://localhost:8080/items/1

# Update an item
curl -X PUT http://localhost:8080/items/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Margherita Pizza","price":13.0}'

# Delete an item
curl -X DELETE http://localhost:8080/items/2
