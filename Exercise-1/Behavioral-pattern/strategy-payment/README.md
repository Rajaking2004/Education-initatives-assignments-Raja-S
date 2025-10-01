# 💳 Strategy Pattern – E-Commerce Payment Checkout Example

## 1. Project Overview
This project demonstrates the **Strategy Design Pattern** using an **E-Commerce Checkout System**.  

In the system:
- The `Order` class delegates payment processing to an **IPaymentStrategy**.  
- Users can choose different payment methods (Credit Card, PayPal, UPI) **at runtime**.  
- The payment logic is **encapsulated** in separate strategy classes, making it easy to add new payment methods later.

---

## 2. Folder Structure
```
Behavioral-pattern/
strategy-payment/
├── com/example/ecommerce/
│   ├── IPaymentStrategy.java
│   ├── CreditCardPayment.java
│   ├── PayPalPayment.java
│   ├── UPIPayment.java
│   ├── Order.java
│   ├── CheckoutApp.java       (main class)
│   └── InMemoryLogger.java    
└── README.md
```



---

## 3. Compilation & Execution

### Step 1 – Navigate
```
cd Behavioral-pattern/strategy-payment
```
Step 2 – Compile
```
javac com/example/payment/*.java
```
Step 3 – Run
```
java com.example.payment.CheckoutApp
```
4. Example Run
```
=== E-Commerce Checkout (Strategy Pattern) ===
Enter order amount: 1000

Choose payment method: 1) Credit Card  2) PayPal  3) UPI  4) Checkout & Exit
2
Enter PayPal email: universe@gmail.com
?? Processing PayPal payment of $1000.0 for account: universe@gmail.com

Choose payment method: 1) Credit Card  2) PayPal  3) UPI  4) Checkout & Exit
3
Enter UPI ID (e.g., user@bank): universe@statebank
? Processing UPI payment of $1000.0 via UPI ID: universe@statebank

Choose payment method: 1) Credit Card  2) PayPal  3) UPI  4) Checkout & Exit
4
Thank you for shopping with us!

=== Log History ===
[2025-10-01T20:16:19.357511] [INFO] Checkout App started.
[2025-10-01T20:16:23.789844200] [INFO] Order created with amount: 1000.0
[2025-10-01T20:16:39.681765600] [INFO] Payment completed using PayPal.
[2025-10-01T20:17:01.917567600] [INFO] Payment completed using UPI.  
[2025-10-01T20:17:09.115904800] [INFO] User requested checkout & exit.
[2025-10-01T20:17:09.115904800] [INFO] Checkout App terminated.
```
5. How Strategy Pattern is Applied
The Strategy Pattern is applied as follows:

IPaymentStrategy → Interface defining the pay method.

CreditCardPayment, PayPalPayment, UPIPayment → Concrete strategies implementing IPaymentStrategy.

Order → Maintains a reference to IPaymentStrategy and delegates the payment process to it.

CheckoutApp → Client application selects the strategy at runtime.

UML-like Structure
```
IPaymentStrategy (Interface)
       ↑
-------------------------------
|            |               |
CreditCard  PayPal          UPI
Payment    Payment        Payment

Order (Context)  -->  uses IPaymentStrategy
CheckoutApp (Client)
```
6. Key Benefits
✅ Flexible Payment Options → Users can choose at runtime.

✅ Open/Closed Principle → New payment methods can be added without modifying Order.

✅ Encapsulates Behavior → Payment logic is separated from order processing.

✅ Reusable and Maintainable → Each payment strategy is independent.