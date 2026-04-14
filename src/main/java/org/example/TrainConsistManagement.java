package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

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

    // ---------------- UC12 ----------------
    public static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    // ---------------- UC13 ----------------

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
    }

    // Measure loop time
    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    // Measure stream time
    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    // Optional main method
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 50 + (i % 50)));
        }

        long loopTime = measureLoopTime(bogies);
        long streamTime = measureStreamTime(bogies);

        System.out.println("Loop Time: " + loopTime);
        System.out.println("Stream Time: " + streamTime);
    }
}