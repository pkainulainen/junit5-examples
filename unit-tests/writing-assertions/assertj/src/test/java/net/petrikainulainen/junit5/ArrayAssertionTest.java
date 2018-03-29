package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for arrays
 * by using AssertJ.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Write assertions for arrays")
class ArrayAssertionTest {

    @Nested
    @DisplayName("When two arrays are equal")
    class WhenArraysAreEqual {

        @Nested
        @DisplayName("When arrays contain integers")
        class WhenArraysContainIntegers {

            final int[] ACTUAL = new int[]{2, 5, 7};
            final int[] EXPECTED = new int[]{2, 5, 7};

            @Test
            @DisplayName("Should contain the same integers")
            void shouldContainSameIntegers() {
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Should contain the same integers (with custom error message)")
            void shouldContainSameIntegersWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected array: %s but got array: %s",
                                Arrays.toString(EXPECTED),
                                Arrays.toString(ACTUAL)
                        )
                        .isEqualTo(EXPECTED);
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
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Should contain the same strings (with custom error message)")
            void shouldContainSameStringsWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected array: %s but got array: %s",
                                Arrays.toString(EXPECTED),
                                Arrays.toString(ACTUAL)
                        )
                        .isEqualTo(EXPECTED);
            }
        }
    }

    @Nested
    @DisplayName("When two arrays are not equal")
    class WhenArraysAreNotEqual {

        @Nested
        @DisplayName("When arrays contain integers")
        class WhenArraysContainIntegers {

            final int[] ACTUAL = new int[]{2, 6, 7};
            final int[] EXPECTED = new int[]{2, 5, 7};

            @Test
            @DisplayName("Should not contain the same integers")
            void shouldNotContainSameIntegers() {
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Should not contain the same integers (with custom error message)")
            void shouldNotContainSameIntegersWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected arrays to not be equal but both are: %s",
                                Arrays.toString(EXPECTED)
                        )
                        .isNotEqualTo(EXPECTED);
            }
        }

        @Nested
        @DisplayName("When arrays contain strings")
        class WhenArraysContainStrings {

            final String[] ACTUAL = new String[] {"foo", "bar1"};
            final String[] EXPECTED = new String[] {"foo", "bar"};

            @Test
            @DisplayName("Should not contain the same strings")
            void shouldNotContainSameStrings() {
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Should not contain the same strings (with custom error message)")
            void shouldNotContainSameStringsWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected arrays to not be equal but both are: %s",
                                Arrays.toString(EXPECTED)
                        )
                        .isNotEqualTo(EXPECTED);
            }
        }
    }
}
