package org.example;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    // UC8
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
    }

    // UC9
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    // UC10
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    // UC11
    public static boolean isValidTrainID(String trainId) {
        return Pattern.matches("TRN-\\d{4}", trainId);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    // UC12
    public static boolean isTrainSafe(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    // UC13
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
    }

    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingLoop(bogies);
        return System.nanoTime() - start;
    }

    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingStream(bogies);
        return System.nanoTime() - start;
    }

    // UC16
    public static int[] bubbleSortCapacities(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // UC17
    public static String[] sortBogieNames(String[] names) {
        Arrays.sort(names);
        return names;
    }

    // UC18
    public static boolean linearSearchBogie(String[] bogieIds, String key) {
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // UC19
    public static boolean binarySearchBogie(String[] bogieIds, String key) {

        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        Arrays.sort(bogieIds); // ensure sorted

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}