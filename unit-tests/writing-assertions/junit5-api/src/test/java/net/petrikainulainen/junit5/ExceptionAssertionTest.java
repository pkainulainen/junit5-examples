package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class demonstrates how we can write assertions for the
 * exceptions thrown by the system under test.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Writing assertions for exceptions")
class ExceptionAssertionTest {

    @Nested
    @DisplayName("When the system under test throws an exception")
    class WhenSystemUnderTestThrowsException {

        @Nested
        @DisplayName("When the system under test throws the correct exception")
        class WhenSystemUnderTestThrowsCorrectException {

            @Test
            @DisplayName("Should throw the correct exception")
            void shouldThrowCorrectException() {
                assertThrows(NullPointerException.class, () -> { throw new NullPointerException(); });
            }

            @Test
            @DisplayName("Should throw the correct exception (with custom error message)")
            void shouldThrowCorrectExceptionWithCustomErrorMessage() {
                assertThrows(NullPointerException.class,
                        () -> { throw new NullPointerException(); },
                        "The code didn't throw a NullPointerException"
                );
            }
        }

        @Nested
        @DisplayName("When the system under test throws an exception that has the correct message")
        class WhenSystemUnderTestThrowsExceptionWithCorrectMessage {

            @Test
            @DisplayName("Should throw an exception that has the correct message")
            void shouldThrowAnExceptionWithCorrectMessage() {
                final NullPointerException thrown = assertThrows(NullPointerException.class,
                        () -> { throw new NullPointerException("Hello World!"); }
                );
                assertEquals("Hello World!", thrown.getMessage(), "The thrown exception don't have the correct error message");
            }
        }
    }

    @Nested
    @DisplayName("When the system under test doesn't throw an exception")
    class WhenSystemUnderTestDoesNotThrowException {

        @Nested
        @DisplayName("When no exception is thrown")
        class WhenNoExceptionIsThrown {

            @Test
            @DisplayName("Should not throw an exception")
            void shouldNotThrowException() {
                assertDoesNotThrow(() -> {});
            }

            @Test
            @DisplayName("Should not throw an exception (with a custom error message)")
            void shouldNotThrowExceptionWithCustomErrorMessage() {
                assertDoesNotThrow(() -> {}, "The system under test threw an exception");
            }
        }
    }
}
