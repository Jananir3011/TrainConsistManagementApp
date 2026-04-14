import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    // UC8 - Filter Passenger Bogies Using Streams
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies) {

        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
    }


    // UC9 - Group Bogies by Type
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {

        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }


    // Display Method
    public static void displayBogies(List<Bogie> bogies) {

        bogies.forEach(System.out::println);
    }


    // Display Grouped Bogies
    public static void displayGroupedBogies(Map<String, List<Bogie>> groupedBogies) {

        groupedBogies.forEach((type, bogieList) -> {

            System.out.println("Type: " + type);

            bogieList.forEach(b ->
                    System.out.println("  " + b)
            );

            System.out.println();
        });
    }


    // Main Method
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("AC Chair", 65));

        System.out.println("Filtered Bogies (Capacity > 60):");

        List<Bogie> filtered =
                filterHighCapacityBogies(bogies);

        displayBogies(filtered);


        System.out.println("\nGrouped Bogies:");

        Map<String, List<Bogie>> grouped =
                groupBogiesByType(bogies);

        displayGroupedBogies(grouped);
    }
}