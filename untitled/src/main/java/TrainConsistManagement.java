import java.util.*;
import java.util.regex.*;
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

    // UC10 - Total Seats
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    // UC11 - Validate Train ID
    public static boolean isValidTrainID(String trainId) {
        String regex = "TRN-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    // UC11 - Validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        String regex = "PET-[A-Z]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
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
        displayBogies(filterHighCapacityBogies(bogies));

        // UC9
        System.out.println("\nGrouped Bogies:");
        displayGroupedBogies(groupBogiesByType(bogies));

        // UC10
        System.out.println("Total Seats = " + calculateTotalSeats(bogies));

        // UC11
        System.out.println("\nValidation:");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID " + trainId + " valid? " + isValidTrainID(trainId));
        System.out.println("Cargo Code " + cargoCode + " valid? " + isValidCargoCode(cargoCode));
    }
}