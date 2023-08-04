# Spring Boot Quizzer Backend

![GitHub last commit](https://img.shields.io/github/last-commit/prashant461/spring-boot-quizzer)

Spring Boot Quizzer Backend is the backend implementation of a user-friendly quiz application built with Spring Boot, PostgreSQL, and Spring Data JPA. The backend provides API endpoints to manage quizzes and questions for the quiz application.

## Features

- Get all quiz questions from the database.
- Get quiz questions filtered by category.
- Add new quiz questions to the database.
- Create a quiz with random questions.
- Get quiz questions for a specific quiz by ID.
- Calculate the score for a submitted quiz.

## Technologies Used

- Spring Boot
- PostgreSQL
- Spring Data JPA

## API Endpoints

- **GET /api/question/allquestions**: Get all quiz questions.
- **GET /api/question/category/{category}**: Get quiz questions filtered by category.
- **POST /api/question/addquestion**: Add a new quiz question.
- **POST /api/quiz/create**: Create a new quiz with random questions.
- **GET /api/quiz/get/{id}**: Get quiz questions for a specific quiz by ID.
- **POST /api/quiz/submit/{id}**: Submit responses for a quiz and calculate the score.

## Installation and Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/prashant461/spring-boot-quizzer.git
   cd spring-boot-quizzer
Set up the PostgreSQL database (make sure you have PostgreSQL installed):

sql
Copy code
# Create the database
CREATE DATABASE questiondb;
Update database configuration in application.properties:

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
Run the application:


# Testing the API
To test the API endpoints, you can use tools like Postman. Here's how you can get started:

1. Install Postman on your machine (if not already installed).
2. Open Postman and create a new request.
3. Enter the URL of the API endpoint you want to test, such as http://localhost:8080/question/allquestions for getting all quiz questions.
4. Select the appropriate HTTP method (GET, POST, etc.).
5. If needed, add request parameters or a request body.
6. Click the "Send" button to make the API request and see the response.
7. You can use Postman to test all the API endpoints provided by the Spring Boot Quizzer Backend.

Let's make learning fun with the Spring Boot Quizzer Backend! 🚀
