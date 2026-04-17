package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementTest {

    // UC14
    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("Sleeper", 50);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", 0);
        });
    }

    // UC15
    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.getCargo());
    }

    // UC16
    @Test
    void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        assertArrayEquals(new int[]{24, 56, 60, 70, 72},
                TrainConsistManagement.bubbleSortCapacities(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        assertArrayEquals(new int[]{24, 56, 60, 70, 72},
                TrainConsistManagement.bubbleSortCapacities(input));
    }

    @Test
    void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        assertArrayEquals(new int[]{24, 56, 56, 72},
                TrainConsistManagement.bubbleSortCapacities(input));
    }

    @Test
    void testSort_SingleElementArray() {
        int[] input = {50};
        assertArrayEquals(new int[]{50},
                TrainConsistManagement.bubbleSortCapacities(input));
    }

    @Test
    void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        assertArrayEquals(new int[]{40, 40, 40},
                TrainConsistManagement.bubbleSortCapacities(input));
    }
}