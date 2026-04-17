package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    // UC20
    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] ids = {};

        assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagement.binarySearchBogie(ids, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] ids = {"BG101","BG205"};

        assertDoesNotThrow(() -> {
            TrainConsistManagement.binarySearchBogie(ids, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] ids = {"BG101","BG205","BG309"};

        assertTrue(TrainConsistManagement.binarySearchBogie(ids, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] ids = {"BG101","BG205","BG309"};

        assertFalse(TrainConsistManagement.binarySearchBogie(ids, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] ids = {"BG101"};

        assertTrue(TrainConsistManagement.binarySearchBogie(ids, "BG101"));
    }
}