# Online-Auction-System

## Project Description

The Online Auction System is a Java-based application that allows users to participate in auctions through a secure and user-friendly interface. The system supports two main types of users: Auctioneers and Bidders. Auctioneers can create and manage auctions, while Bidders can place bids on available auctions.

## Features

- **User Registration and Login**: Users can log in as either an Auctioneer or a Bidder.
- **Auction Creation**: Auctioneers can create auctions for products they want to sell.
- **Bidding System**: Bidders can place bids on open auctions and compete to win products.
- **Auction Management**: Auctioneers can close auctions and view the highest bid.
- **Auction Listing**: Users can view all available auctions along with the current highest bids.

## System Requirements

- Java Development Kit (JDK) 8 or later
- Any Java-compatible IDE (Eclipse, IntelliJ IDEA, etc.) or command-line tools

## Installation and Setup

1. **Clone the Repository:**
    ```bash
    git clone <repository-url>
    ```
    Or download the project as a ZIP file and extract it.

2. **Navigate to the Project Directory:**
    ```bash
    cd online-auction-system
    ```

3. **Compile the Code:**
    ```bash
    javac Main.java
    ```

4. **Run the Application:**
    ```bash
    java Main
    ```

## How to Use

1. **User Login:**
    - Predefined users are already registered for demo purposes:
      - Auctioneer: `username: auctioneer1, password: password123`
      - Bidder 1: `username: bidder1, password: password456`
      - Bidder 2: `username: bidder2, password: password789`

2. **Menu Options:**
    - **Login**: Enter your username and password to log in as a Bidder or Auctioneer.
    - **View Auctions**: Displays all available auctions with their details.
    - **Place Bid**: Allows Bidders to place a bid on an auction by providing the auction ID and bid amount.
    - **Close Auction**: Auctioneers can close an auction after it ends.
    - **Exit**: Exits the application.

3. **Sample Products and Auctions**: The system has predefined products and auctions available for demonstration.

## Code Structure

- **User.java**: Defines the User class and subclasses for Auctioneers and Bidders.
- **Product.java**: Represents a product to be auctioned.
- **Auction.java**: Manages auctions, including the bidding process and auction status.
- **AuctionSystem.java**: Core logic that handles user management, auction creation, bidding, and more.
- **Main.java**: The entry point of the application, providing a menu-driven interface.

## Future Enhancements

- Add a GUI using JavaFX or Swing for a better user experience.
- Implement database integration for user data and auctions.
- Introduce real-time bidding notifications.
- Add security features like encrypted passwords and role-based access control.
- Support for multiple auction types (e.g., reverse auctions).
