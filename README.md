# Online Auction System

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Roles](#roles)
- [System Flow](#system-flow)
- [How to Run](#how-to-run)
- [Example Usage](#example-usage)
- [Code Structure](#code-structure)

## Introduction
This Java console application simulates a basic online auction system where users can log in as either auctioneers or bidders. Auctioneers can close auctions, while bidders can place bids on available products.

## Features
- **User Authentication**: Login with predefined users.
- **Role-Based Access**: Different functionalities for auctioneers and bidders.
- **Auction Management**: View available auctions, place bids, and close auctions.
- **Predefined Users and Products**: The system initializes with a few predefined users and products for demonstration purposes.

## Roles
- **Auctioneer**: Responsible for managing auctions, including closing them.
- **Bidder**: Can view auctions and place bids on open auctions.

## System Flow
1. **Login**: Users are prompted to log in with their credentials.
2. **View Auctions**: Both auctioneers and bidders can view the list of active auctions.
3. **Place Bid**: Bidders can place bids on any open auction.
4. **Close Auction**: Auctioneers can close open auctions once they are satisfied with the bids.
5. **Logout and Exit**: Users can log out or exit the system.

## How to Run
1. Ensure you have a working Java Development Kit (JDK) installed on your machine.
2. Clone or download the project files.
3. Compile the code using the following command:
    ```bash
    javac Online_Auction_System.java
    ```
4. Run the compiled code using:
    ```bash
    java Online_Auction_System
    ```

## Example Usage
### Sample Interaction 1: Auctioneer
```plaintext
--- Online Auction System ---
1. Login
2. View Auctions
3. Place Bid
4. Close Auction (Auctioneer Only)
5. Exit
Enter your choice: 1
Enter username: auctioneer1
Enter password: password123
Login successful! Welcome auctioneer1 (Auctioneer)

--- Online Auction System ---
1. Login
2. View Auctions
3. Place Bid
4. Close Auction (Auctioneer Only)
5. Exit
Enter your choice: 2
Auction ID: 1, Product ID: 1, Name: Antique Vase, Description: A rare antique vase, Starting Price: $100.0, Current Highest Bid: $100.0, Status: Open
Auction ID: 2, Product ID: 2, Name: Vintage Car, Description: A classic vintage car, Starting Price: $5000.0, Current Highest Bid: $5000.0, Status: Open

--- Online Auction System ---
1. Login
2. View Auctions
3. Place Bid
4. Close Auction (Auctioneer Only)
5. Exit
Enter your choice: 4
Enter auction ID to close: 1
Auction ID: 1 has been closed.
```

### Sample Interaction 2: Bidder
```plaintext
--- Online Auction System ---
1. Login
2. View Auctions
3. Place Bid
4. Close Auction (Auctioneer Only)
5. Exit
Enter your choice: 1
Enter username: bidder1
Enter password: password456
Login successful! Welcome bidder1 (Bidder)

--- Online Auction System ---
1. Login
2. View Auctions
3. Place Bid
4. Close Auction (Auctioneer Only)
5. Exit
Enter your choice: 2
Auction ID: 1, Product ID: 1, Name: Antique Vase, Description: A rare antique vase, Starting Price: $100.0, Current Highest Bid: $100.0, Status: Closed
Auction ID: 2, Product ID: 2, Name: Vintage Car, Description: A classic vintage car, Starting Price: $5000.0, Current Highest Bid: $5000.0, Status: Open

--- Online Auction System ---
1. Login
2. View Auctions
3. Place Bid
4. Close Auction (Auctioneer Only)
5. Exit
Enter your choice: 3
Enter auction ID: 2
Enter your bid amount: 6000
Bid placed successfully by bidder1 for $6000.0
```

## Code Structure
- **User**: Represents a user in the system. Has attributes like `username`, `password`, and `role`.
- **Product**: Represents a product that can be auctioned. Contains details like `productId`, `name`, `description`, and `startingPrice`.
- **Auction**: Represents an auction. Contains information about the product being auctioned, the highest bid, the current highest bidder, and whether the auction is open or closed.
- **AuctionSystem**: Handles the system's core logic, including managing users, auctions, and role-based operations.
- **Online_Auction_System**: The main class that provides the user interface and interacts with the user.

## Future Enhancements
- Add user registration and product creation functionalities.
- Implement dynamic auction loading from a database or file.
- Improve the user interface with a graphical UI.

