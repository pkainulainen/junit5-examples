package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class demonstrates how we can write assertions for booleans
 * with JUnit 5 and Hamcrest.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Write assertions for booleans")
class BooleanAssertionTest {

    @Nested
    @DisplayName("When boolean is false")
    class WhenBooleanIsFalse {

        @Test
        @DisplayName("Should be false")
        void shouldBeFalse() {
            assertThat(false, is(false));
        }

        @Test
        @DisplayName("Should be false (with custom error message)")
        void shouldBeFalseWithCustomErrorMessage() {
            assertThat("The boolean is not false", false, is(false));
        }
    }

    @Nested
    @DisplayName("When boolean is true")
    class WhenBooleanIsTrue {

        @Test
        @DisplayName("Should be true")
        void shouldBeTrue() {
            assertThat(true, is(true));
        }

        @Test
        @DisplayName("Should be true (with custom error message)")
        void shouldTrueWithCustomErrorMessage() {
            assertThat("The boolean is not true", true, is(true));
        }
    }
}
