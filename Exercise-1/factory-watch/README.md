# ⌚ Factory Pattern – Watch Factory Example

## 1. Project Overview
This project demonstrates the **Factory Design Pattern** using a **Watch Factory** as a real-world analogy.  

In the system:
- Customers can request different types of watches (Digital, Analog, Smart).  
- Instead of creating watch objects directly in the client code, a **WatchFactory** decides which object to create.  

This follows the **Factory Pattern**, where object creation logic is encapsulated in a factory class.

---

## 2. Folder Structure
```
factory-watch/
├── com/example/watch/
│   ├── Watch.java
│   ├── DigitalWatch.java
│   ├── AnalogWatch.java
│   ├── SmartWatch.java
│   ├── WatchFactory.java
│   ├── WatchFactoryApp.java   (main class)
│   └── InMemoryLogger.java    
└── README.md
```


---

## 3. Compilation & Execution

### Step 1 – Navigate
```
cd factory-watch
```
Step 2 – Compile
```
javac com/example/watch/*.java
```
Step 3 – Run
```
java com.example.watch.WatchFactoryApp
```
4. Example Run
```
[INFO] 2025-10-01 20:08:39 - Watch Factory started.

=== Watch Factory Menu ===
Choose watch type: 1) Digital  2) Analog  3) Smart  4) Exit
Enter choice: 1
[INFO] 2025-10-01 20:08:41 - Created watch: DigitalWatch
? Digital Watch - Time: 20:08:41

=== Watch Factory Menu ===
Choose watch type: 1) Digital  2) Analog  3) Smart  4) Exit
Enter choice: 2
[INFO] 2025-10-01 20:08:43 - Created watch: AnalogWatch
? Analog Watch - Hour hand at 8, Minute hand at 8

=== Watch Factory Menu ===
Choose watch type: 1) Digital  2) Analog  3) Smart  4) Exit
Enter choice: 3
[INFO] 2025-10-01 20:08:44 - Created watch: SmartWatch
? Smart Watch - Full Date & Time: 2025-10-01 20:08:44 | Notifications: ON

=== Watch Factory Menu ===
Choose watch type: 1) Digital  2) Analog  3) Smart  4) Exit
Enter choice: 4
[INFO] 2025-10-01 20:08:45 - User requested exit.
[INFO] 2025-10-01 20:08:45 - Watch Factory terminated.
Exiting Watch Factory. Goodbye!

=== Log History ===
[INFO] 2025-10-01 20:08:39 - Watch Factory started.
[INFO] 2025-10-01 20:08:41 - Created watch: DigitalWatch
[INFO] 2025-10-01 20:08:43 - Created watch: AnalogWatch
[INFO] 2025-10-01 20:08:44 - Created watch: SmartWatch
[INFO] 2025-10-01 20:08:45 - User requested exit.
[INFO] 2025-10-01 20:08:45 - Watch Factory terminated.
```
5. How Factory Pattern is Applied
The Factory Pattern is applied as follows:

Watch → Interface (common behavior for all watches).

DigitalWatch, AnalogWatch, SmartWatch → Concrete implementations.

WatchFactory → Factory class that creates the right type of watch.

WatchFactoryApp → Client application that delegates object creation to the factory.

UML-like Structure
```
            Watch (Interface)
                 ↑
   --------------------------------
   |              |               |
DigitalWatch   AnalogWatch   SmartWatch

        WatchFactory (Creator)
                ↑
         WatchFactoryApp (Client)
```
6. Key Benefits
✅ Encapsulates Object Creation → Client does not worry about which class to instantiate.

✅ Open/Closed Principle → New watch types can be added without modifying client code.

✅ Simplifies Client Code → Keeps object creation logic in one place.

7. Conclusion
The Factory Pattern centralizes the creation of watch objects, making the system easy to extend and maintain.
This is similar to a real-world watch factory, where the customer just orders a type of watch and the factory handles the rest