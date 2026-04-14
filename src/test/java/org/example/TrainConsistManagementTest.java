package org.example;

import org.example.GoodsBogie;
import org.example.TrainConsistManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class TrainConsistManagementTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );

        Assertions.assertTrue(TrainConsistManagement.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainConsistManagement.isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainConsistManagement.isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainConsistManagement.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(TrainConsistManagement.isTrainSafe(list));
    }
}
