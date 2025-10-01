PC Builder Application
Overview

The PC Builder Application is a console-based Java program that demonstrates the Builder Design Pattern. It allows users to construct a custom personal computer (PC) by selecting required and optional components. Additionally, it supports predefined configurations such as Gaming PCs and Office PCs using a Director class.

The program follows best practices including:

One class per file

Defensive programming and input validations

In-memory logging of events and errors

Exception handling

Controlled loops for user input


Project Structure
```
pc-builder-demo/
 └─ com/example/pc/
     ├─ Builder.java          // Builder interface
     ├─ InMemoryLogger.java   // Simple in-memory logging
     ├─ PC.java               // Product class representing a PC
     ├─ PCBuilder.java        // Concrete Builder class
     ├─ Director.java         // Director for pre-defined PC configurations
     └─ PersonalComputerApp.java // Main client program
```
Key Classes and Their Responsibilities
1. Builder<T> Interface

Defines the generic build() method for builders.

Ensures that any concrete builder implements the method to return the final product.
```
public interface Builder<T> {
    T build();
}
```
2. PC (Product)

Represents the final product.

Contains required components (Motherboard, CPU, RAM, Storage, Power Supply) and optional components.

The constructor is only accessible through the builder.

3. PCBuilder (Concrete Builder)

Implements the Builder<PC> interface.

Provides fluent setters for all required and optional components.

Performs input validation for all fields.

Logs events and errors using InMemoryLogger.

Builds and returns a PC object via build() method.

Highlights of Builder Pattern Usage:

Separates the construction logic from the representation (PC object).

Allows step-by-step construction of a complex object.

Supports optional components without creating multiple constructors.

Enables fluent API chaining.

4. Director

Encapsulates predefined construction sequences like Gaming PC and Office PC.

Accepts a builder object and sets fields using builder methods.

Demonstrates how construction steps can be reused for different product variations.

director.constructGamingPC();


This separates what to build from how to build.

5. InMemoryLogger

Captures program events and errors in memory for debugging purposes.

Provides info(), error(), and warn() methods.

Logs can be printed or cleared as needed.

6. PersonalComputerApp (Client)

Interacts with the user through the console.

Allows users to choose pre-built PC or custom build.

Collects input for required and optional components.

Calls builder.build() to construct the final product.

Prints logs and the built PC configuration.

How Builder Pattern is Applied

Separate Construction from Representation

The PCBuilder is responsible for assembling the PC, while the PC class just stores the final configuration.

Step-by-Step Construction

Required and optional components are set via individual methods (setCpu(), setRam(), addOptionalComponent()), allowing flexibility.

Fluent Interface

Builder methods return this, allowing chained method calls for readability.

Director Class for Predefined Variations

Director encapsulates specific sequences of builder steps, showing how the same builder can create different products.

Defensive Programming and Validation

Builder validates inputs at every step. Invalid values throw exceptions and are logged.

Optional Components and Customization

Builder allows adding optional components without overloading constructors or creating multiple product classes.

Running the Program
#navigate to pc-builder-demo
```
cd pc-builder-demo
```
Compile all Java files:
```
javac  com/example/pc/*.java
```

Run the program:
```
java  com.example.pc.PersonalComputerApp
```



Choose pre-built PC (gaming/office) or custom build

Enter required components if not using a pre-built option

Add optional components

View the final PC configuration and logs

Sample Output
```
=== PC Builder Demo ===
Do you want a pre-built PC? (yes/no): yes
Type 'gaming' or 'office': gaming

✅ PC successfully built!
PC Configuration:
Motherboard: Z790 Gaming
CPU: Intel i9
RAM: 32GB DDR5
Storage: 2TB NVMe SSD
Power Supply: 850W
Optional Components: RGB Lighting, Liquid Cooling

=== Logs ===
[INFO] Motherboard set to Z790 Gaming
[INFO] CPU set to Intel i9
[INFO] RAM set to 32GB DDR5
[INFO] Storage set to 2TB NVMe SSD
[INFO] Power Supply set to 850W
[INFO] Added optional component: RGB Lighting
[INFO] Added optional component: Liquid Cooling
[INFO] PC successfully built!
```
Advantages of Builder Pattern in This Project

Scalable: Easily add new PC types or products (Laptop, Server).

Readable: Chained builder methods improve code readability.

Flexible: Supports optional components without creating many constructors.

Reusable: Director allows reusing the same construction sequence.

Safe: Input validation and logging improve program robustness.
 UML-like structure
 ```
                <<interface>>
                Builder<T>
                   |
                   |
           ----------------
           |              |
       PCBuilder         OtherBuilder?
           |
           |
          PC  (Product)
          
           ^
           |
       Director
           |
           | uses PCBuilder to construct specific PC types
           |
       PersonalComputerApp
```