#  E-Commerce System  
### Fawry Rise Full Stack Development Internship Challenge  

---

##  Description

This is a console-based **E-Commerce System** implemented in **Java**, designed to simulate a minimal shopping cart experience with support for:

- Expirable Products  
- Shippable Products  
- Digital Products  
- Cart and Checkout  
- Shipping Service Integration  

It was built as a solution to the **Fawry Rise Full Stack Development Internship Challenge**.

---

##  Features

- ✅ **Define Products** with name, price, quantity
- ✅ Support for:
  - **Expirable products** (e.g., Milk, Cheese)
  - **Shippable products** (e.g., TV, Books)
  - **Digital products** (e.g., Scratch Cards)
  - **Expirable + Shippable** products (e.g., Cheese)
- ✅ Add products to the **Cart** (with quantity validation)
- ✅ Handle **expired** and **out-of-stock** scenarios
- ✅ Perform **Checkout** with:
  - Subtotal
  - Shipping fees (flat rate: 30 EGP if shipment needed)
  - Total paid
  - Updated customer balance
- ✅ **ShippingService** processes all shippable items

---
##  Sample Console Output

```
** Checkout receipt **
2x    Cheese      200.0
1x    Biscuits      150.0
1x    Scratch Card      50.0
ExpiredMilk is expired and cannot be added

----------------------
** Shipment notice **
1x Biscuits 700.0g
1x Cheese 200.0g
Total package weight 0.9kg
----------------------
Subtotal 400
Shipping 30
Amount 430
Balance 70
```
##  Business Rules

- ❌ Products cannot be added to cart if expired
- ❌ Quantity must not exceed available stock
- ❌ Cart cannot be checked out if empty
- ❌ Customer must have enough balance
-  Only shippable items are passed to `ShippingService`

---

##  Assumptions

- All prices are in Egyptian Pounds (EGP)
- Expiry is validated against the system date using `LocalDate.now()`
- Shipping fee is a flat **30 EGP** per order (if any shippable item exists)
- Weight is in **kilograms** (displayed in grams during shipping)

##  How to Run

1. Ensure you have **Java 8+** installed
2. Compile all `.java` files using:

```bash
javac *.java
java Main
```

That is it, Thanks.




