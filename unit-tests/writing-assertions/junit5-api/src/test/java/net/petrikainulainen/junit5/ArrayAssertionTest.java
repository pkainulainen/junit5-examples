package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * This class demonstrates how we can write assertions for arrays
 * by using JUnit 5.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

    @Nested
    @DisplayName("When arrays contain integers")
    class WhenArraysContainIntegers {

        final int[] ACTUAL = new int[]{2, 5, 7};
        final int[] EXPECTED = new int[]{2, 5, 7};

        @Test
        @DisplayName("Should contain the same integers")
        void shouldContainSameIntegers() {
            assertArrayEquals(EXPECTED, ACTUAL);
        }

        @Test
        @DisplayName("Should contain the same integers (with custom error message)")
        void shouldContainSameIntegersWithCustomErrorMessage() {
            assertArrayEquals(
                    EXPECTED,
                    ACTUAL,
                    "The arrays don't contain the same integers"
            );
        }
    }

    @Nested
    @DisplayName("When arrays contain strings")
    class WhenArraysContainStrings {

        final String[] ACTUAL = new String[] {"foo", "bar"};
        final String[] EXPECTED = new String[] {"foo", "bar"};

        @Test
        @DisplayName("Should contain the same strings")
        void shouldContainSameStrings() {
            assertArrayEquals(EXPECTED, ACTUAL);
        }

        @Test
        @DisplayName("Should contain the same strings (with custom error message)")
        void shouldContainSameStringsWithCustomErrorMessage() {
            assertArrayEquals(
                    EXPECTED,
                    ACTUAL,
                    "The arrays don't contain the same strings"
            );
        }
    }
}
