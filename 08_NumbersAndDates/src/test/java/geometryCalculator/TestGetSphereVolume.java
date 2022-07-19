package geometryCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import homework_01.GeometryCalculator;

@DisplayName("Тест метода getSphereVolume класса GeometryCalculator")
public class TestGetSphereVolume {

    private static final double DELTA = 0.01;

    @Test
    @DisplayName("Передано положительное целое число 20")
    void testGetSphereVolumeWithPositiveIntegerNumber() {
        double expected = 33510.32163829113;
        Assertions.assertEquals(expected, GeometryCalculator.getSphereVolume(20), DELTA);
    }

    @Test
    @DisplayName("Передан 0")
    void testGetSphereVolumeWithZero() {
        double expected = 0;
        Assertions.assertEquals(expected, GeometryCalculator.getSphereVolume(0), DELTA);
    }

    @Test
    @DisplayName("Передано отрицательное целое число -20")
    void testGetSphereVolumeWithNegativeIntegerNumber() {
        double expected = -1;
        Assertions.assertEquals(expected, GeometryCalculator.getSphereVolume(-20), DELTA);
    }

    @Test
    @DisplayName("Передано положительное дробное число 20.2")
    void testGetSphereVolumeWithPositiveFractionalNumber() {
        double expected = 34525.71789425298;
        Assertions.assertEquals(expected, GeometryCalculator.getSphereVolume(20.2), DELTA);
    }

}
