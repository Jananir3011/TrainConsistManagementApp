import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TrainConsistManagementTest {

    // UC10
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

    // UC11 - Train ID Tests
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

    // UC11 - Cargo Code Tests
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
}