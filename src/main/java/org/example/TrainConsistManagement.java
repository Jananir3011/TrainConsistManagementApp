package org.example;

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

    // UC11 - Regex Validation
    public static boolean isValidTrainID(String trainId) {
        return Pattern.compile("TRN-\\d{4}")
                .matcher(trainId)
                .matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.compile("PET-[A-Z]{2}")
                .matcher(cargoCode)
                .matches();
    }

    // UC12 - Safety Compliance for Goods Bogies
    public static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {

        return goodsBogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
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

    public static void main(String[] args) {

        // Passenger Bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("AC Chair", 65));

        // UC8
        System.out.println("Filtered Bogies:");
        displayBogies(filterHighCapacityBogies(bogies));

        // UC9
        System.out.println("\nGrouped Bogies:");
        displayGroupedBogies(groupBogiesByType(bogies));

        // UC10
        System.out.println("\nTotal Seats = " + calculateTotalSeats(bogies));

        // UC11
        System.out.println("\nValidation:");
        System.out.println(isValidTrainID("TRN-1234"));
        System.out.println(isValidCargoCode("PET-AB"));

        // UC12 - Goods Bogies
        List<GoodsBogie> goods = new ArrayList<>();

        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Open", "Coal"));
        goods.add(new GoodsBogie("Box", "Grain"));

        boolean safe = isTrainSafe(goods);

        System.out.println("\nSafety Compliance: " + safe);
    }
}