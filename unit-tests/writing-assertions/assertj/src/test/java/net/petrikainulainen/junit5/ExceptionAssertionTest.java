package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * This class demonstrates how we can write assertions for the
 * exceptions thrown by the system under test with AssertJ.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Writing assertions for exceptions")
class ExceptionAssertionTest {

    @Nested
    @DisplayName("When the system under test throws the correct exception")
    class WhenSystemUnderTestThrowsException {

        @Test
        @DisplayName("Should throw the correct exception")
        void shouldThrowCorrectException() {
            final Throwable thrown = catchThrowable(() -> { throw new NullPointerException(); });
            assertThat(thrown).isExactlyInstanceOf(NullPointerException.class);
        }

        @Test
        @DisplayName("Should throw the correct exception (with custom error message)")
        void shouldThrowCorrectExceptionWithCustomErrorMessage() {
            final Throwable thrown = catchThrowable(() -> { throw new NullPointerException(); });
            assertThat(thrown)
                    .overridingErrorMessage(
                            "Expected the code to throw a NullPointerException but it threw: %s",
                            thrown.getClass().getSimpleName()
                    )
                    .isExactlyInstanceOf(NullPointerException.class);
        }
    }

    @Nested
    @DisplayName("When the system under test throws an exception that has the correct message")
    class WhenSystemUnderTestThrowsExceptionWithCorrectMessage {

        private final String ERROR_MESSAGE = "Hello World!";

        @Test
        @DisplayName("Should throw an exception that has the correct message")
        void shouldThrowAnExceptionWithCorrectMessage() {
            final Throwable thrown = catchThrowable(() -> { throw new NullPointerException(ERROR_MESSAGE); });
            assertThat(thrown.getMessage())
                    .overridingErrorMessage(
                            "Expected the error message of the exception to be: %s but it was: %s",
                            ERROR_MESSAGE,
                            thrown.getMessage()
                    )
                    .isEqualTo(ERROR_MESSAGE);
        }
    }
}
