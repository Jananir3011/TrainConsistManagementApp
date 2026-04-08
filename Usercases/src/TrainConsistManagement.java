import java.util.ArrayList;
import java.util.Scanner;

// Base Bogie class
abstract class Bogie {
    protected String bogieId;

    public Bogie(String bogieId) {
        this.bogieId = bogieId;
    }

    public String getBogieId() {
        return bogieId;
    }

    public abstract void displayInfo();
}

// Passenger Bogie class
class PassengerBogie extends Bogie {
    private String type; // Sleeper, AC Chair, First Class
    private int seatCapacity;
    private int bookedSeats;

    public PassengerBogie(String bogieId, String type, int seatCapacity) {
        super(bogieId);
        this.type = type;
        this.seatCapacity = seatCapacity;
        this.bookedSeats = 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Passenger Bogie [" + bogieId + "] Type=" + type
                + ", Capacity=" + seatCapacity + ", Booked=" + bookedSeats);
    }
}

// Train class
class Train {
    private String trainId;
    private ArrayList<Bogie> bogies;

    public Train(String trainId) {
        this.trainId = trainId;
        this.bogies = new ArrayList<>();
    }

    // Add a bogie
    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
        System.out.println("Bogie " + bogie.getBogieId() + " added to train.");
    }

    // Remove a bogie by ID
    public void removeBogie(String bogieId) {
        boolean removed = bogies.removeIf(b -> b.getBogieId().equals(bogieId));
        if (removed) System.out.println("Bogie " + bogieId + " removed.");
        else System.out.println("Bogie " + bogieId + " not found.");
    }

    // Check if a bogie exists
    public boolean hasBogie(String bogieId) {
        return bogies.stream().anyMatch(b -> b.getBogieId().equals(bogieId));
    }

    // Display all bogies
    public void displayBogies() {
        System.out.println("\nTrain " + trainId + " Consist:");
        if (bogies.isEmpty()) {
            System.out.println("No bogies attached.");
        } else {
            for (Bogie b : bogies) {
                b.displayInfo();
            }
        }
    }
}

// Main App
public class TrainConsistManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train("Train-101");

        while (true) {
            System.out.println("\n--- Train Consist Management ---");
            System.out.println("1. Add Passenger Bogie");
            System.out.println("2. Remove Bogie");
            System.out.println("3. Check Bogie Existence");
            System.out.println("4. Display All Bogies");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Bogie ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Type (Sleeper/AC Chair/First Class): ");
                    String type = sc.nextLine();
                    System.out.print("Enter Seat Capacity: ");
                    int cap = sc.nextInt();
                    sc.nextLine();
                    PassengerBogie pb = new PassengerBogie(id, type, cap);
                    train.addBogie(pb);
                    break;
                case 2:
                    System.out.print("Enter Bogie ID to Remove: ");
                    String removeId = sc.nextLine();
                    train.removeBogie(removeId);
                    break;
                case 3:
                    System.out.print("Enter Bogie ID to Check: ");
                    String checkId = sc.nextLine();
                    if (train.hasBogie(checkId)) {
                        System.out.println("Bogie " + checkId + " exists.");
                    } else {
                        System.out.println("Bogie " + checkId + " not found.");
                    }
                    break;
                case 4:
                    train.displayBogies();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
