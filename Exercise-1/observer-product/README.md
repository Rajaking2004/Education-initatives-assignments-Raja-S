# 📢 Observer Pattern – Product Notifications Example

## 1. Project Overview
This project demonstrates the **Observer Design Pattern** using an **E-Commerce Product Notification System**.  

In the system:
- Customers (observers) can **subscribe** to notifications for a specific product.  
- When the product comes back **in stock** (state change), all subscribed customers are automatically **notified** via Email or SMS.  
- This pattern decouples the product (subject) from its subscribers (observers), allowing flexible notification management.

---

## 2. Folder Structure
```
observer-product/
├── com/example/ecommerce/
│   ├── Observer.java
│   ├── Customer.java
│   ├── Product.java
│   ├── NotificationType.java
│   ├── EcommerceApp.java      (main class)
│   └── InMemoryLogger.java    
└── README.md
```



---

## 3. Compilation & Execution

### Step 1 – Navigate
```
cd observer-product
```
Step 2 – Compile

```
javac com/example/ecommerce/*.java
```
Step 3 – Run
```
java com.example.ecommerce.EcommerceApp
```
4. Example Run
```
[INFO] 2025-10-01 20:12:49 - E-commerce Observer App started.

Menu:
1) Subscribe to notifications
2) Restock product
3) Exit
Enter your choice: 1
Enter your name: Laptop
Choose notification type (EMAIL/SMS): SMS
? Customer subscribed to Gaming Laptop
[INFO] 2025-10-01 20:13:05 - Customer subscribed: Laptop via SMS

Menu:
1) Subscribe to notifications
2) Restock product
3) Exit
Enter your choice: 2
[INFO] 2025-10-01 20:13:10 - Restocking product: Gaming Laptop

? Product 'Gaming Laptop' is now in stock!
? Notification to Laptop via SMS: Product 'Gaming Laptop' is back in stock!

Menu:
1) Subscribe to notifications
2) Restock product
3) Exit
Enter your choice: 3
[INFO] 2025-10-01 20:13:16 - Exit requested by user.
[INFO] 2025-10-01 20:13:16 - E-commerce Observer App terminated.     
Goodbye!

=== LOG HISTORY ===
[INFO] 2025-10-01 20:12:49 - E-commerce Observer App started.        
[INFO] 2025-10-01 20:13:05 - Customer subscribed: Laptop via SMS     
[INFO] 2025-10-01 20:13:10 - Restocking product: Gaming Laptop       
[INFO] 2025-10-01 20:13:16 - Exit requested by user.
[INFO] 2025-10-01 20:13:16 - E-commerce Observer App terminated. 
```
5. How Observer Pattern is Applied
The Observer Pattern is applied as follows:

Observer → Interface for all observers (customers).

Customer → Implements Observer and receives notifications.

Product → Subject that maintains a list of observers and notifies them on state changes.

EcommerceApp → Client application that allows customers to subscribe and triggers restock events.

UML-like Structure
```
Observer (Interface)
       ↑
   Customer

Subject: Product
  - List<Observer>
  - attach(Observer)
  - detach(Observer)
  - notifyObservers()

EcommerceApp (Client)
```
6. Key Benefits
✅ Decouples Subject and Observers → Product does not depend on how notifications are sent.

✅ Dynamic Subscription → Observers can subscribe/unsubscribe at runtime.

✅ Automatic Updates → All subscribers are notified whenever the product state changes.

✅ Flexible and Scalable → Can add new notification methods (Email/SMS/Push) easily.

7. Conclusion
The Observer Pattern allows a product to broadcast state changes to multiple subscribers in a flexible and maintainable way.
It’s a real-world analogy of e-commerce notifications for back-in-stock products.

