# 💰 Virtual Bank Application for Kids
**Midterm Project for SE-25**

## 🏁 Submission 1: Product Backlog and Prototype (Scrum Method)
This repository contains the first submission for the Virtual Bank Application. The project is being developed using **Agile Methods** and follows the specifications provided in the SE-25 midterm handout.

### 📋 Product Backlog
The complete product backlog with user stories, acceptance criteria, priorities, and estimations (Story Points) can be found here:
👉 **[ProductBacklog.md](ProductBacklog.md)**

### 🎨 Prototype Overview
The prototype focuses on the core banking experience for children, including account management, task rewards, and savings goals.

- **GUI Framework**: JavaFX 17 with FXML and custom CSS.
- **Visual Design**: Modern, kid-friendly dashboard with progress bars and colorful cards.
- **Mockup Image**: You can view the high-fidelity UI proposal in the **[Prototype Walkthrough](UML_Diagram.md)** (Note: I've also added a mockup in the repository).
- **FXML Source**: The UI layout is defined in `src/main/resources/com/bankforkids/fxml/MainView.fxml`.

### 🏗️ Software Architecture
The application follows the **MVC (Model-View-Controller)** pattern for clean separation of concerns.
- **View**: JavaFX FXML + CSS.
- **Controller**: JavaFX Controller for UI logic.
- **Model**: Child, Account (Current/Savings), Task, Goal, Transaction.
- **Persistence**: Local object serialization (offline mode, no database required).
- **UML Diagram**: Check the detailed class relationships in **[UML_Diagram.md](UML_Diagram.md)**.

### 🛠️ Technologies
- **Language**: Java 11
- **GUI**: JavaFX
- **Testing**: JUnit 4 (TDD approach)
- **Build System**: Maven (see [pom.xml](pom.xml))

### 🚀 How to Run (Prototype Phase)
1. Ensure Java 11+ and Maven are installed.
2. Run `mvn javafx:run` to launch the application prototype.
3. Unit tests can be run via `mvn test`.

---
*Developed by Group 777 (Midterm Project SE-25)*