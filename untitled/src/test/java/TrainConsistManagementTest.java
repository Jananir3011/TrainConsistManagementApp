import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementTest {

    @Test
    void testGrouping_BogiesGroupedByType() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result =
                TrainConsistManagement.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
    }


    @Test
    void testGrouping_DifferentBogieTypes() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result =
                TrainConsistManagement.groupBogiesByType(bogies);

        assertEquals(2, result.size());
    }


    @Test
    void testGrouping_EmptyBogieList() {

        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result =
                TrainConsistManagement.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }


    @Test
    void testGrouping_SingleBogieCategory() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72)
        );

        Map<String, List<Bogie>> result =
                TrainConsistManagement.groupBogiesByType(bogies);

        assertEquals(1, result.size());
    }


    @Test
    void testGrouping_MapContainsCorrectKeys() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );

        Map<String, List<Bogie>> result =
                TrainConsistManagement.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }
}