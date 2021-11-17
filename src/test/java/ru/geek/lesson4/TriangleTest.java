package ru.geek.lesson4;


import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Nested
    @DisplayName("Тесты для треугольника:")
    class UnitTests {

        @Test
        @DisplayName("Такой треугольник создать нельзя")
        void zeroAreaTriangleCanNotBeCreated() {
            assertThrows(IllegalArgumentException.class,() -> new TriangleApp(0,0,0));
        }

        @Test
        @DisplayName("С отрицательными значениями сторон треугольник создать нельзя")
        void negativeLengthSideTriangleCanNotBeCreated() {
            assertThrows(IllegalArgumentException.class,() -> new TriangleApp(-3,-100,2));
        }

        @Test
        @DisplayName( ("Треугольник создается без ошибок"))
        void validTriangleCanBeCreated() {
            new TriangleApp(3,4,5);
        }

        @Test
        @DisplayName("Площадь треугольника рассчитывается без ошибок")
        void areaCalculation() {
            TriangleApp triangle = new TriangleApp(3,4,5);
            assertEquals(triangle.area(),6);
            logger.info("Test is successful");
        }
    }
}
