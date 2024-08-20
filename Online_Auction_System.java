import java.util.*;

class User {
    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

class Product {
    private int productId;
    private String name;
    private String description;
    private double startingPrice;

    public Product(int productId, String name, String description, double startingPrice) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }
}

class Auction {
    private int auctionId;
    private Product product;
    private double highestBid;
    private String highestBidder;
    private boolean isOpen;

    public Auction(int auctionId, Product product) {
        this.auctionId = auctionId;
        this.product = product;
        this.highestBid = product.getStartingPrice();
        this.highestBidder = "None";
        this.isOpen = true;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public Product getProduct() {
        return product;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public String getHighestBidder() {
        return highestBidder;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void placeBid(String bidder, double bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidder;
            System.out.println("Bid placed successfully by " + bidder + " for $" + bidAmount);
        } else {
            System.out.println("Bid amount is too low. Current highest bid is $" + highestBid);
        }
    }

    public void closeAuction() {
        isOpen = false;
        System.out.println("Auction ID: " + auctionId + " has been closed.");
    }
}

class AuctionSystem {
    private Map<String, User> users;
    private List<Auction> auctions;
    private User currentUser;

    public AuctionSystem() {
        users = new HashMap<>();
        auctions = new ArrayList<>();
        loadPredefinedUsers();
        loadPredefinedAuctions();
    }

    private void loadPredefinedUsers() {
        users.put("auctioneer1", new User("auctioneer1", "password123", "Auctioneer"));
        users.put("bidder1", new User("bidder1", "password456", "Bidder"));
        users.put("bidder2", new User("bidder2", "password789", "Bidder"));
    }

    private void loadPredefinedAuctions() {
        Product product1 = new Product(1, "Antique Vase", "A rare antique vase", 100.0);
        Product product2 = new Product(2, "Vintage Car", "A classic vintage car", 5000.0);
        auctions.add(new Auction(1, product1));
        auctions.add(new Auction(2, product2));
    }

    public void login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome " + username + " (" + user.getRole() + ")");
            } else {
                System.out.println("Login failed! Invalid credentials.");
            }
        } else {
            System.out.println("Login failed! Invalid credentials.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void viewAuctions() {
        for (Auction auction : auctions) {
            System.out.println("Auction ID: " + auction.getAuctionId() + ", Product ID: " + auction.getProduct().getProductId() +
                               ", Name: " + auction.getProduct().getName() + ", Description: " + auction.getProduct().getDescription() +
                               ", Starting Price: $" + auction.getProduct().getStartingPrice() +
                               ", Current Highest Bid: $" + auction.getHighestBid() +
                               ", Status: " + (auction.isOpen() ? "Open" : "Closed"));
        }
    }

    public void placeBid(int auctionId, double bidAmount) {
        if (getCurrentUser() == null || !"Bidder".equals(getCurrentUser().getRole())) {
            System.out.println("Invalid user or role.");
            return;
        }

        for (Auction auction : auctions) {
            if (auction.getAuctionId() == auctionId) {
                if (auction.isOpen()) {
                    auction.placeBid(getCurrentUser().getUsername(), bidAmount);
                } else {
                    System.out.println("The auction is closed.");
                }
                return;
            }
        }
        System.out.println("Invalid auction ID.");
    }

    public void closeAuction(int auctionId) {
        if (getCurrentUser() == null || !"Auctioneer".equals(getCurrentUser().getRole())) {
            System.out.println("Invalid user or role.");
            return;
        }

        for (Auction auction : auctions) {
            if (auction.getAuctionId() == auctionId) {
                if (auction.isOpen()) {
                    auction.closeAuction();
                } else {
                    System.out.println("The auction is already closed.");
                }
                return;
            }
        }
        System.out.println("Invalid auction ID.");
    }

    public void logout() {
        currentUser = null;
        System.out.println("You have been logged out.");
    }
}

public class Online_Auction_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuctionSystem auctionSystem = new AuctionSystem();

        while (true) {
            System.out.println("\n--- Online Auction System ---");
            System.out.println("1. Login");
            System.out.println("2. View Auctions");
            System.out.println("3. Place Bid");
            System.out.println("4. Close Auction (Auctioneer Only)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    auctionSystem.login(username, password);
                    break;

                case 2:
                    auctionSystem.viewAuctions();
                    break;

                case 3:
                    if (auctionSystem.getCurrentUser() == null || !"Bidder".equals(auctionSystem.getCurrentUser().getRole())) {
                        System.out.println("Invalid user or role.");
                        break;
                    }
                    System.out.print("Enter auction ID: ");
                    int auctionId = scanner.nextInt();
                    System.out.print("Enter your bid amount: ");
                    double bidAmount = scanner.nextDouble();
                    auctionSystem.placeBid(auctionId, bidAmount);
                    break;

                case 4:
                    if (auctionSystem.getCurrentUser() == null || !"Auctioneer".equals(auctionSystem.getCurrentUser().getRole())) {
                        System.out.println("Invalid user or role.");
                        break;
                    }
                    System.out.print("Enter auction ID to close: ");
                    int closeAuctionId = scanner.nextInt();
                    auctionSystem.closeAuction(closeAuctionId);
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}