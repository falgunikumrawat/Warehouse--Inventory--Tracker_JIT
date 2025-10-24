#  Warehouse Inventory Tracker (Event-Based project)

##  Project Overview
The Warehouse Inventory Tracker is a Java-based application that simulates an event-driven inventory management system.
It helps track multiple products, manage stock in real time, and automatically generate alerts when the stock level goes below a predefined threshold.
The project is built using core Java concepts and demonstrates event-based programming through the Observer Design Pattern.

##  Features
- Add new products dynamically (each with unique ID, name, quantity, and threshold)
- Increase stock when shipments arrives
- Decrease stock when customer orders are fulfilled
- Auto alert when stock goes below the threshold
- Proper error handling for invalid inputs or insufficient stock
- Bonus tasks:
  - Used multithreading to handle multiple stock updates at once
  - File handling to save inventory data
  - Can simulate more than one warehouse

##  Classes and Their Roles
- *Product.java* → Holds product details (ID, name, quantity, threshold)
- *Warehouse.java* → Handles adding, receiving, and fulfilling orders
- *AlertService.java* → Interface that triggers low stock alert
- *Main.java* → The main driver class that tests and all functions

##  Concepts Used
- Object-Oriented Programming: Encapsulation, Abstraction, and Modularity.
- Collections: Used HashMap and List to store and manage products efficiently.
- Observer Design Pattern: To generate alerts dynamically when stock is low.
- Exception Handling: Prevents invalid operations and ensures program stability.
- File Handling: Stores data persistently between runs(Bonus).
- Multithreading: Demonstrates concurrent stock updates(Bonus).


##  How to Run the Program
1. Open terminal inside the project folder.  
2. Compile all files:  
   ```bash
   javac *.java

3. Run the program:
     ```bash
      java Main
- Follow the on-screen instructions to test various operations like adding, updating, and fulfilling orders.


##  Author
    **Falguni Kumrawat**
      October 2025 

   