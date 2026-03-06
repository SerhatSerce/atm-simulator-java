# ATM Simulator (Java)
Console-based ATM simulation built with Java using OOP and layered architecture principles.
This project demonstrates how a simple banking ATM system can be structured using clean separation of concerns such as **Model, Repository, Service, and UI layers**.

# Features
- Multi-user login (PIN based authentication)
- Balance inquiry
- Deposit money
- Withdraw money
- Basic input validation
- Layered architecture (Model, Repository, Service, UI)

# Architecture
The project follows a simplified layered architecture:
UI → Service → Repository → Model

- **UI Layer**  
  Handles user interaction via console.

- **Service Layer**  
  Contains business logic such as authentication and account operations.

- **Repository Layer**  
  Simulates a data source and stores account data.

- **Model Layer**  
  Represents domain objects (Account).

# Project Structure
com.serhat.atm
│
├── model
│   └── Account.java
│
├── repository
│   └── AccountRepository.java
│
├── service
│   ├── AccountService.java
│   └── AuthService.java
│
├── ui
│   └── AtmConsoleUI.java
│
└── AtmApp.java
```

# Technologies

- Java
- Object Oriented Programming (OOP)
- Layered Architecture
- IntelliJ IDEA

---

# How to Run
1. Clone the repository
git clone https://github.com/SerhatSerce/atm-simulator-java.git
2. Open the project in **IntelliJ IDEA**
3. Run the application:
AtmApp.java

# Example Accounts

| PIN | Balance |
|-----|--------|
| 1111 | 1000 |
| 2222 | 500 |
| 3333 | 2000 |

---

# Learning Goals

This project was created to practice:

- Java OOP
- Layered architecture
- Clean code structure
- Basic service / repository separation
