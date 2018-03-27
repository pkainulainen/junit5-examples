package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrates how we can write assertions
 * for {@code Optional} objects with AssertJ.
 */
@DisplayName("Writing assertions for Optional objects")
class OptionalAssertionTest {

    @Nested
    @DisplayName("When the optional is empty")
    class WhenOptionalIsEmpty {

        @Test
        @DisplayName("Should be empty")
        void shouldBeEmpty() {
            assertThat(Optional.empty()).isEmpty();
        }

        @Test
        @DisplayName("Should be empty (with custom error message)")
        void shouldBeEmptyWithCustomErrorMessage() {
            final Optional<Object> empty = Optional.empty();
            assertThat(empty)
                    .overridingErrorMessage("Expected optional to be empty but it was: %s", empty)
                    .isEmpty();
        }
    }

    @Nested
    @DisplayName("When the optional is not empty")
    class WhenOptionalIsNotEmpty {

        private final Object OBJECT = new Object();

        @Test
        @DisplayName("Should not be empty")
        void shouldNotBeEmpty() {
            assertThat(Optional.of(OBJECT)).isNotEmpty();
        }

        @Test
        @DisplayName("Should not be empty (with custom error message)")
        void shouldNotBeEmptyWithCustomErrorMessage() {
            assertThat(Optional.of(OBJECT))
                    .overridingErrorMessage("Expected optional to not be empty but it was empty")
                    .isNotEmpty();
        }

        @Test
        @DisplayName("Should contain the correct object")
        void shouldContainCorrectObject() {
            assertThat(Optional.of(OBJECT)).contains(OBJECT);
        }

        @Test
        @DisplayName("Should contain the correct object (with custom error message)")
        void shouldContainCorrectObjectWithCustomErrorMessage() {
            final Optional<Object> actual = Optional.of(OBJECT);
            assertThat(actual)
                    .overridingErrorMessage(
                            "Expected optional to contain the object: %s but it contained the object: %s",
                            OBJECT,
                            actual.get()
                    )
                    .contains(OBJECT);
        }
    }
}
