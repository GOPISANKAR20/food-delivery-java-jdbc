# Food Delivery Application

A console-based Food Delivery Application developed using Java, JDBC and MySQL.

## Features

- User Registration
- User Login
- Display Food Menu
- Select Food and Quantity
- Calculate Order Total
- Place Order
- View Order History

## Technologies Used

- Java
- JDBC
- MySQL
- Eclipse IDE
- Git & GitHub

## Project Flow

User Registration
        ↓
User Login
        ↓
View Food Menu
        ↓
Select Food & Quantity
        ↓
Calculate Total
        ↓
Place Order
        ↓
Store Order in MySQL
        ↓
View Order History

## Database Tables

- users
- food_items
- orders
- order_items

## JDBC

JDBC is used to connect the Java application with the MySQL database and execute SQL queries.

## How to Run

1. Create the `food_delivery` database in MySQL.
2. Create the required tables.
3. Add MySQL Connector/J to the project.
4. Update the MySQL username and password in `DBConnection.java`.
5. Run the Java classes from Eclipse.

## Project Structure

src/
└── fooddelivery/
    ├── DBConnection.java
    ├── User.java
    ├── Login.java
    ├── FoodMenu.java
    ├── Cart.java
    ├── Order.java
    └── OrderHistory.java