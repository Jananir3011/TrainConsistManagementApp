package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    // UC17
    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        assertArrayEquals(new String[]{
                "AC Chair","First Class","General","Luxury","Sleeper"
        }, TrainConsistManagement.sortBogieNames(input));
    }

    // UC18
    @Test
    void testSearch_BogieFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagement.linearSearchBogie(ids, "BG309"));
    }

    // UC19
    @Test
    void testBinarySearch_BogieFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagement.binarySearchBogie(ids, "BG309"));
    }
}