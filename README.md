Gym Microservices

A sample project demonstrating a **microservices architecture** with Spring Boot.  
This system includes **3 independent services** that communicate via REST APIs.

---

Services

| Service | Default Port | Description |
|---------|--------------|-------------|
| **User Service** | `8081` | Manage users (register, get user info) |
| **Booking Service** | `8082` | Manage class or session bookings |
| **Notification Service** | `8083` | Send notifications to users (e.g., booking confirmation) |

---

## Project Setup

### Prerequisites
-  **Java 17+**
-  **Maven 3.8+**
-  **Git**

### Steps to Run
1. Clone the repository:
   ```
   git clone https://github.com/<username>/gym-microservices.git
   cd gym-microservices
Run each service separately:


cd user-service
mvn spring-boot:run
(Repeat for booking-service and notification-service.)

Testing the Services
1-Test User Service

curl http://localhost:8081/users
2-Test Booking Service
Book a sample class:


curl -X POST http://localhost:8082/bookings \
     -H "Content-Type: application/json" \
     -d '{"userId":1,"className":"Yoga"}'
3-Test Notification Service
Send a test notification:

curl http://localhost:8083/notify?userId=1
Project Structure
sql
gym-microservices/
│
├─ user-service/          → User management
├─ booking-service/       → Booking management
└─ notification-service/  → Notification management
