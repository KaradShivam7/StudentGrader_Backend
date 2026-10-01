 🎓 Student Grader System

 📌 Project Overview
The Student Grader System is a full-stack web application developed to conduct online examinations, automatically evaluate student responses, and manage grading efficiently.
It is designed for educational institutions to reduce manual evaluation effort and provide quick, accurate results.

The system follows a client-server architecture with a modern frontend and a secure backend.

---

 🎯 Objectives
- Automate student assessment and grading
- Provide role-based access for Admin and Students
- Ensure secure and scalable exam management
- Offer a clean and responsive user interface

---

 🚀 Key Features

 👨‍🎓 Student Module
- Student registration and login
- Attempt online examinations
- Submit answers securely
- View results and grades instantly

 👨‍🏫 Admin Module
- Admin authentication
- Add, update, and delete students
- Upload and manage exam questions
- Automatic evaluation of answers
- Monitor student performance
- Send email notifications using SMTP

 ⚙️ System Features
- RESTful API architecture
- Role-based access control
- JSON-based question management
- Secure authentication and authorization
- MySQL database integration
- Responsive UI

---

 🛠️ Technology Stack

 Frontend
- React.js (Vite)
- HTML5, CSS3
- JavaScript (ES6+)
- Axios
- Bootstrap / Custom CSS

 Backend
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- Maven

 Database
- MySQL

---

 🏗️ Architecture
- Frontend communicates with backend via REST APIs
- Backend handles authentication, business logic, and database operations
- Database stores users, questions, answers, and results

---

 📁 Project Structure

 ├── Studentgraderbackend/
│   └── StudentGrader/
│       ├── src/main/java/
│       │   └── com/StudentGrader/
│       │       ├── Controller/
│       │       ├── Service/
│       │       ├── Repository/
│       │       ├── Entity/
│       │       └── Config/
│       ├── src/main/resources/
│       │   ├── application.properties
│       │   └── questions_full.json
│       └── pom.xml

 ⚙️ Backend Setup (Spring Boot)

### Step 1: Database Configuration
Edit application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/studentgrader
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
### Step 2: Run Backend
cd Studentgraderbackend/StudentGrader
mvn spring-boot:run
Backend runs on:
http://localhost:8080
---

 🌐 Frontend Setup (React + Vite)

Step 1: Install Dependencies
 cd Graderfinal
 npm install
Step 2: Start Frontend Server
npm run dev
Frontend runs on:
http://localhost:5173
---

 🔐 Security
- Spring Security for authentication
- Role-based access control (Admin / Student)
- Password encryption
- Secured API endpoints

---

 📡 API Communication
- Axios used for frontend-backend communication
- REST APIs for login, exams, evaluation, and admin actions

---

 📧 Email Service
- SMTP-based email service
- Automatic notifications for exam results and admin activities

---

 🧪 Testing
- Backend tested using Spring Boot Test
- APIs verified using Postman

---

 📌 Future Enhancements
- JWT-based authentication
- Exam timer and auto-submit
- Analytics dashboard for admins
- Cloud deployment (AWS / Railway / Render)
- File upload support for descriptive answers

---

 👨‍💻 Author

Amar Bhise   

---

 📄 License
This project is developed for educational purposes and can be freely modified or extended.

---

⭐ If you like this project, please star the repository!
