# Calculator Hub Backend

## 📌 Project Description
This project is a backend platform developed using Spring Boot. It provides multiple calculator APIs for different real-world use cases like finance, personal, health, and business calculations.

## 🚀 Features
- Finance Calculators:
    - EMI
    - GST
    - ROI
    - Simple Interest
    - Break-even

- Personal Calculators:
    - Age
    - Percentage
    - Time Duration
    - Date Difference

- Health Calculators:
    - BMI
    - Calories
    - Water Intake

- Business Calculators:
    - Profit Margin
    - Startup Valuation
    - Cost Estimator

## 🗄 Database
- MySQL database used
- Table: `calculations`
- Stores all calculation history with type, inputs, and results

## ⚙️ Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- REST APIs

## 🌐 Base URL
http://localhost:8080/api/calculators

## 🧪 Example APIs

### BMI
GET /api/calculators/bmi?weight=70&height=1.75

### GST
GET /api/calculators/gst?amount=1000&rate=18

### Profit
GET /api/calculators/profit?revenue=10000&cost=7000

## ▶️ How to Run

1. Open project in IntelliJ
2. Configure MySQL database:
    - Database name: calculatorhub
3. Run:
   CalculatorhubApplication.java
4. Use Postman to test APIs

## 📊 Additional Features
- History tracking
- Filter by calculation type
- Delete records
- Dashboard analytics

---

## 👨‍💻 Developed By
Sharath Kumar