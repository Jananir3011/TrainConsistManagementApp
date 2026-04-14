package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class TrainConsistManagementTest {
// ---------- UC10 Tests ----------

    @Test
    void testReduce_TotalSeatCalculation() {
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

// ---------- UC11 Tests ----------

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagement.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagement.isValidTrainID("TRAIN12"));
        assertFalse(TrainConsistManagement.isValidTrainID("TRN12A"));
        assertFalse(TrainConsistManagement.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistManagement.isValidTrainID("TRN-123"));
        assertFalse(TrainConsistManagement.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagement.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagement.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistManagement.isValidCargoCode("PET123"));
        assertFalse(TrainConsistManagement.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistManagement.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagement.isValidTrainID(""));
        assertFalse(TrainConsistManagement.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistManagement.isValidTrainID("TRN-1234XYZ"));
        assertFalse(TrainConsistManagement.isValidCargoCode("PET-AB123"));
    }
    // ---------- UC12 Tests ----------

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );

        assertTrue(TrainConsistManagement.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainConsistManagement.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();
        assertTrue(TrainConsistManagement.isTrainSafe(list));
    }

    // ---------- UC13 Tests ----------

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 50)
        );

        List<Bogie> result = TrainConsistManagement.filterUsingLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 40)
        );

        List<Bogie> result = TrainConsistManagement.filterUsingStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 40),
                new Bogie("First Class", 90)
        );

        List<Bogie> loopResult = TrainConsistManagement.filterUsingLoop(list);
        List<Bogie> streamResult = TrainConsistManagement.filterUsingStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new Bogie("Sleeper", 70));
        }

        long loopTime = TrainConsistManagement.measureLoopTime(list);
        long streamTime = TrainConsistManagement.measureStreamTime(list);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("Sleeper", 50 + (i % 100)));
        }

        List<Bogie> result = TrainConsistManagement.filterUsingStream(list);

        assertTrue(result.size() > 0);
    }
}