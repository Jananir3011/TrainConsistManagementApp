import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementTest {

    // UC10 Tests

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        int result = TrainConsistManagement.calculateTotalSeats(bogies);
        assertEquals(172, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("Sleeper", 80)
        );

        int result = TrainConsistManagement.calculateTotalSeats(bogies);
        assertEquals(150, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(
                new Bogie("AC Chair", 60)
        );

        int result = TrainConsistManagement.calculateTotalSeats(bogies);
        assertEquals(60, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int result = TrainConsistManagement.calculateTotalSeats(bogies);
        assertEquals(0, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 30),
                new Bogie("First Class", 20)
        );

        int result = TrainConsistManagement.calculateTotalSeats(bogies);
        assertEquals(100, result);
    }
}