# Quiz App API 🎯

This project is a **Quiz App API** built using **Spring Boot**. It provides endpoints for creating quiz sessions, fetching random questions, submitting answers, and tracking quiz statistics. 🚀

---

## Features 🌟

- Start a new quiz session 🆕
- Fetch random multiple-choice questions 🎲
- Submit answers ✅❌
- View statistics for correct and incorrect answers 📊

---

## Technologies Used 💻

- **Spring Boot** for backend development
- **H2 Database** for in-memory data storage
- **JPA** for database interaction
- **Postman** for API testing

---

## Endpoints 📡

1. **Start a Quiz Session**  
   **Endpoint**: `POST /quiz/start`  
   **Description**: Starts a new quiz session. Clears previous session data. 🆕

2. **Fetch a Random Question**  
   **Endpoint**: `GET /quiz/question`  
   **Description**: Retrieves a random question that hasn’t been answered yet. 🎲

3. **Submit an Answer**  
   **Endpoint**: `POST /quiz/answer`  
   **Description**: Submits an answer for a specific question ID. Returns whether the answer is correct or incorrect. ✅❌

4. **Get Statistics**  
   **Endpoint**: `GET /quiz/stats`  
   **Description**: Provides stats for the current quiz session, including total answered questions, correct answers, and incorrect answers. 📊

---

## Setup Instructions 🛠️

1. Clone the repository:  
   ```bash
   git clone https://github.com/your-repo/quiz-app-api.git
   ```

2. Navigate to the project directory:  
   ```bash
   cd quiz-app-api
   ```

3. Run the application:  
   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the H2 Database console:  
   **URL**: `http://localhost:8080/h2-console`  
   **JDBC URL**: `jdbc:h2:mem:testdb`  
   **Username**: `sa`  
   **Password**: *(leave blank)*

---

## Database Schema 🗃️

- **Question Table**
  - `id`: Unique identifier for the question
  - `question`: Text of the question
  - `options`: List of answer choices
  - `correctAnswer`: Correct answer for the question

---

## Assumptions 📋

- The application seeds the database with a predefined set of questions. 📝
- A single user can participate in a quiz session at a time.
- No user authentication or authorization is implemented.

---

## Example Questions ❓

1. **What is the size of `int` in Java?**  
   - Options: `2 bytes`, `4 bytes`, `8 bytes`, `16 bytes`  
   - Correct Answer: `4 bytes`

2. **What is the default value of a boolean variable in Java?**  
   - Options: `true`, `false`, `null`, `0`  
   - Correct Answer: `false`

---

## License 📄

This project is licensed under the MIT License. 📝
