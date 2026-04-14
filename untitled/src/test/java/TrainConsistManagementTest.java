import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TrainConsistManagementTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 60),
                new Bogie("First", 80)
        );

        List<Bogie> result =
                TrainConsistManagement.filterBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {

        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC", 50),
                new Bogie("First", 40)
        );

        List<Bogie> result =
                TrainConsistManagement.filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }
}