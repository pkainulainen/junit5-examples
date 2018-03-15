package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * This class demonstrates how we can write assertions for
 * the execution time of the system under test.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Writing assertions for the execution time of the system under test")
class TimeoutAssertionTest {

    @Nested
    @DisplayName("When the execution is not aborted if the timeout is exceeded")
    class WhenExecutionIsNotAborted {

        @Test
        @DisplayName("Should return the correct message before timeout is exceeded")
        void shouldReturnCorrectMessageBeforeTimeoutIsExceeded() {
            final String message = assertTimeout(Duration.ofMillis(50), () -> {
                Thread.sleep(20);
                return "Hello World!";
            });
            assertEquals("Hello World!", message);
        }
    }

    @Nested
    @DisplayName("When the execution is aborted if the timeout is exceeded")
    class WhenExecutionIsAborted {

        @Test
        @DisplayName("Should return the correct message before timeout is exceeded")
        void shouldReturnCorrectMessageBeforeTimeoutIsExceeded() {
            final String message = assertTimeoutPreemptively(Duration.ofMillis(50), () -> {
                Thread.sleep(20);
                return "Hello World!";
            });
            assertEquals("Hello World!", message);
        }
    }
}
