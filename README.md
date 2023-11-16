
# Order System Java GUI Application

This is a Java GUI application for an order system, where users can register, manage products, and place orders. The system includes features for both users and administrators, leveraging a MySQL database for data storage.

## Features

### User Features

1. **User Registration:**
   - Users can register with their necessary details, stored securely in the database.

2. **Product Management:**
   - Users can add, view, and manage products in their inventory.

3. **Order Placement:**
   - Users can place Pickup Orders (send items to the store) and Delivery Orders (send items to customers).

### Admin Features

1. **User Management:**
   - Admins can manage users by registering, viewing, and deleting user accounts.

2. **Product Management:**
   - Admins can add, view, update, and delete products, ensuring real-time synchronization with the database.

3. **Order Management:**
   - Admins can view and update the status of orders, informing customers about the progress.

## Database Connectivity

- MySQL is used as the backend database.
- Java Database Connectivity (JDBC) is utilized for connecting the Java application with the MySQL database.

## GUI Implementation

- The graphical user interface is built using Java's Swing or JavaFX.
- Proper validation is implemented to ensure data integrity and security.

## Security Considerations

- Passwords are securely stored using hashing and salting techniques.
- Access control is enforced to restrict actions to authorized users.

## Progress Notifications

- Users receive real-time notifications on the status of their orders.
- Admins can efficiently update order status.

## Technologies Used

- Java for application logic and GUI.
- MySQL for the database.
- JDBC for database connectivity.

## Getting Started

1. Clone the repository.
2. Set up the MySQL database and update the connection details in the application.
3. Run the Java application.
