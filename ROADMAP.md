# Roadmap

## ✅ Phase 1 — Project Setup (This PR)
- [x] Spring Boot project scaffolding
- [x] Entity design & JPA relationships
- [x] Repository, Service, Controller layers
- [x] H2 in-memory database
- [x] Exception handling
- [x] Swagger/OpenAPI docs
- [x] Seed data

## 🔲 Phase 2 — Enhancements
- [ ] Add pagination and sorting to all list endpoints
- [ ] Add filtering (by author, category, availability) to book search
- [ ] Add overdue loan scheduler (`@Scheduled`) to auto-update loan statuses daily

## 🔲 Phase 3 — Testing
- [ ] Unit tests for all service classes using JUnit 5 + Mockito
- [ ] Integration tests for controllers using `@SpringBootTest` + MockMvc
- [ ] Repository tests using `@DataJpaTest`

## 🔲 Phase 4 — Security (Optional Stretch Goal)
- [ ] Add Spring Security with JWT authentication
- [ ] Role-based access: `LIBRARIAN` and `MEMBER` roles
- [ ] Secure endpoints accordingly

## 🔲 Phase 5 — Production Readiness
- [ ] Switch from H2 to PostgreSQL with Docker Compose setup
- [ ] Add Flyway for database migrations
- [ ] Add Spring Boot Actuator for health checks
- [ ] Dockerize the application
