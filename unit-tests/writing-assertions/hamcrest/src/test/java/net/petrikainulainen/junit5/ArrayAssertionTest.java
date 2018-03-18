package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class demonstrates how we can write assertions for arrays
 * by using JUnit 5 and Hamcrest.
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
            assertThat(ACTUAL, is(EXPECTED));
        }

        @Test
        @DisplayName("Should contain the same integers (with custom error message)")
        void shouldContainSameIntegersWithCustomErrorMessage() {
            assertThat("The arrays don't contain the same integers",
                    ACTUAL,
                    is(EXPECTED)
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
            assertThat(ACTUAL, is(EXPECTED));
        }

        @Test
        @DisplayName("Should contain the same strings (with custom error message)")
        void shouldContainSameStringsWithCustomErrorMessage() {
            assertThat("The arrays don't contain the same strings",
                    ACTUAL,
                    is(EXPECTED)
            );
        }
    }
}
