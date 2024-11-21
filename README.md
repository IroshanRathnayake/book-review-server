# Book Review System - Backend
**Version**: 1.0.0

Welcome to the backend of the Book Review System repository! This backend is built with Java Spring Boot to handle all the server-side logic for managing book reviews, including storing, updating, and retrieving reviews.

## Features
1. **Add Reviews**
    - Allows users to submit new book reviews with details like title, author, review text, and rating.

2. **Update Reviews**
    - Provides functionality to update existing book reviews.

3. **View Reviews**
    - Displays all reviews stored in the database with the necessary details.

4. **Filter Reviews**
    - Provides sorting and filtering options, such as filtering reviews by date, rating, or popularity.

## Tech Stack
- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **API**: RESTful APIs for handling review operations (GET, POST, PUT, DELETE)

## Setup Instructions

1. **Clone the repository**

   ```bash
   git clone https://github.com/IroshanRathnayake/book-review-server.git
   ```
2. **Navigate to the project directory**
    ```bash
   cd book-review-system-backend
   ```
3. **Install dependencies**
    ```bash
   mvn clean install
    ```
4. **Configure the application**
   ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/book_review_db?createDatabaseIfNotExist=true
    spring.datasource.username=username
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    ```
5. **Run the backend server**
    ```bash
    mvn spring-boot:run
    ```

## Access the backend
The backend will be running on [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Reviews
- **GET /api/reviews** - Retrieve all reviews.
- **GET /api/reviews/{id}** - Retrieve a specific review by ID.
- **POST /api/reviews** - Add a new review.
- **PUT /api/reviews/{id}** - Update an existing review.
- **DELETE /api/reviews/{id}** - Delete a review.

### Authentication
- **POST /api/auth/login** - Login and receive a JWT token for secure access to protected routes.
- **POST /api/auth/signup** - Register a new users. 
