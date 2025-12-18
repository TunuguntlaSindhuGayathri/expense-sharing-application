# Expense Sharing Application

A simplified backend implementation of an expense sharing system similar to Splitwise.

---

## 🚀 Features
- Create users and groups
- Add shared expenses
- Supports:
    - Equal split
    - Exact amount split
    - Percentage split
- Track balances (who owes whom)

---

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Maven
- REST APIs

---

## 🔗 API Endpoints
- `POST /users` – Create user
- `POST /groups` – Create group
- `POST /expenses` – Add expense
- `GET /balances` – View balances

---

## 🔄 Balance Simplification
Balances are tracked cumulatively.  
Net balances can be computed to reduce settlement transactions (conceptual Splitwise approach).

---

## 🧪 API Testing
A Postman collection is included to test all APIs and split types.

---

## ⚠️ Assumptions
- In-memory storage
- Single currency
- No authentication
