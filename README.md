# Exercise 1: Design Patterns Use Cases

This project demonstrates **six different use cases** to understand various **software design patterns** using Java. Each use case is implemented in a separate folder with proper package structure and README files.

---

## 1. Behavioural Design Patterns

| Pattern | Use Case | Location |
|---------|----------|---------|
| **Strategy Pattern** | E-commerce checkout system supporting multiple payment methods (CreditCard, PayPal, UPI) | `Exercise-1/strategy-payment/` |
| **Observer Pattern** | E-commerce product notifications when items are restocked | `Exercise-1/observer-product/` |

---

## 2. Creational Design Patterns

| Pattern | Use Case | Location |
|---------|----------|---------|
| **Builder Pattern** | Personal Computer (PC) builder with optional components | `Exercise-1/pc-builder-demo/` |
| **Factory Pattern** | Watch factory creating different types of watches (Digital, Analog, Smart) | `Exercise-1/factory-watch/` |

---

## 3. Structural Design Patterns

| Pattern | Use Case | Location |
|---------|----------|---------|
| **Bridge Pattern** | E-Book reader supporting multiple book types and formats | `Exercise-1/bridge-ebook/` |
| **Adapter Pattern** | Weather service integrating a new third-party API with different method signatures | `Exercise-1/adapter-weather/` *(example location)* |

---

### Notes:

- Each folder contains:
  - Java source files (`.java`) following standard package structure.
  - A `README.md` explaining the pattern and code usage.
  - Optional: In-memory logging and validation for robust execution.

- Compile and run each example separately.  
- `.gitignore` ensures that no `.class` or temporary files are pushed to GitHub.
 # Exercise 2: Problem Statements for Mini-projects
 1. Astronaut Daily Schedule Organizer Programming Exercise 
Problem Statement
 Design and implement a console-based application that helps astronauts organize their daily
 schedules. The application should allow users to add, remove, and view daily tasks. Each task
 will have a description, start time, end time, and priority level. The intent behind this problem
 statement is to evaluate your ability to implement a basic CRUD (Create, Read, Update, Delete)
 application, manage data efficiently, and apply best coding practices.
 Functional Requirements
 Mandatory Requirements
 1. Add a new task with description, start time, end time, and priority level.
 2. Remove an existing task.
 3. View all tasks sorted by start time.
 4. Validate that new tasks do not overlap with existing tasks.
 5. Provide appropriate error messages for invalid operations.
 Optional Requirements
 1. Edit an existing task.
 2. Mark tasks as completed.
 3. View tasks for a specific priority level.
 Non-functional Requirements
 1. The application should handle exceptions gracefully.
 2. Ensure the application is optimized for performance.
 3. Implement a logging mechanism for tracking application usage and errors.
 Key Focus
 Design Patterns to be used
 1. Singleton Pattern: Ensure there is only one instance of the schedule manager.
2. Factory Pattern: Use a factory to create task objects.
 3. Observer Pattern: Notify users of task conflicts or updates.
 Detailed Instructions
 1. Use the Singleton Pattern to create a ScheduleManager class that manages all tasks.
 2. Implement a TaskFactory class to create Task objects.
 3. Use the Observer Pattern to alert users if a new task conflicts with an existing one.
 Possible Inputs and Corresponding Outputs
 Positive Cases
 1. Input: Add Task("Morning Exercise", "07:00", "08:00", "High") Output: Task added
 successfully. No conflicts.
 2. Input: Add Task("Team Meeting", "09:00", "10:00", "Medium") Output: Task added
 successfully. No conflicts.
 3. Input: View Tasks Output:
 a. 07:00 - 08:00: Morning Exercise [High]
 b. 09:00 - 10:00: Team Meeting [Medium]
 4. Input: Remove Task("Morning Exercise") Output: Task removed successfully.
 5. Input: Add Task("Lunch Break", "12:00", "13:00", "Low") Output: Task added successfully. No
 conflicts.
 Negative Cases
 1. Input: Add Task("Training Session", "09:30", "10:30", "High") Output: Error: Task conflicts
 with existing task "Team Meeting".
 2. Input: Remove Task("Non-existent Task") Output: Error: Task not found.
 3. Input: Add Task("Invalid Time Task", "25:00", "26:00", "Low") Output: Error: Invalid time
 format.
 4. Input: Add Task("Overlap Task", "08:30", "09:30", "Medium") Output: Error: Task conflicts
 with existing task "Team Meeting".
 5. Input: View Tasks (when no tasks exist) Output: No tasks scheduled for the day.
 Evaluation
 1. Code Quality: Adherence to best practices, use of design patterns, SOLID principles, and
 OOP.
 2. Functionality: All mandatory requirements implemented correctly.
 3. Error Handling: Graceful handling of all errors and edge cases.
 4. Performance: Code is optimized for performance.
5. Explanation: Candidate's ability to walk through the code and explain design decisions and
 logic.
 6. Documentation: Code is well-documented, and usage instructions are clear.
 The goal of this exercise is to assess the candidate's coding skills, understanding of design
 patterns, and ability to produce high-quality, maintainable code.
 
 ##File location and inside Exercise-2 folder it has own README.md file in it that explains the working
 ```
 Exercise-2
└── src/
    └── com/
        └── space/
            └── schedule/
                └── AstronautScheduleApp.java
```
