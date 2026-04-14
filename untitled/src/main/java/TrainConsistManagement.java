import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    // UC8 - Filter Bogies
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
    }

    // UC9 - Group Bogies
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    // UC10 - Total Seat Calculation
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    // Display List
    public static void displayBogies(List<Bogie> bogies) {
        bogies.forEach(System.out::println);
    }

    // Display Grouped
    public static void displayGroupedBogies(Map<String, List<Bogie>> grouped) {
        grouped.forEach((type, list) -> {
            System.out.println("Type: " + type);
            list.forEach(b -> System.out.println("  " + b));
            System.out.println();
        });
    }

    // Main Method
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("AC Chair", 65));

        // UC8
        System.out.println("Filtered Bogies (Capacity > 60):");
        List<Bogie> filtered = filterHighCapacityBogies(bogies);
        displayBogies(filtered);

        // UC9
        System.out.println("\nGrouped Bogies:");
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        displayGroupedBogies(grouped);

        // UC10
        System.out.println("Total Seating Capacity:");
        int totalSeats = calculateTotalSeats(bogies);
        System.out.println("Total Seats = " + totalSeats);
    }
}