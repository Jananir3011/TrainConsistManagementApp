package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementTest {

    // UC10
    @Test
    void testReduce_TotalSeatCalculation() throws InvalidCapacityException {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );
        assertEquals(172, TrainConsistManagement.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        assertEquals(0, TrainConsistManagement.calculateTotalSeats(new ArrayList<>()));
    }

    // UC11
    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagement.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagement.isValidCargoCode("PET123"));
    }

    // UC14
    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("Sleeper", 50);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", 0);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("First Class", 80);
        assertEquals("First Class", b.getType());
        assertEquals(80, b.getCapacity());
    }
}