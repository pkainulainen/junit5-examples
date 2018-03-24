package net.petrikainulainen.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This class demonstrates how we can write assertions for maps
 * by using JUnit 5 and Hamcrest.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Writing assertions for maps")
class MapAssertionTest {

    private static final String INCORRECT_KEY = "incorrectKey";
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private Map<String, String> map;

    @BeforeEach
    void createAndInitializeMap() {
        map = new HashMap<>();
        map.put(KEY, VALUE);
    }

    @Nested
    @DisplayName("When we check if the map contains the given key")
    class WhenWeCheckIfMapContainsGivenKey {

        @Test
        @DisplayName("Should contain the correct key")
        void shouldContainCorrectKey() {
            assertThat(map, hasKey(KEY));
        }

        @Test
        @DisplayName("Should contain the correct key (with custom error message)")
        void shouldContainCorrectKeyWithCustomErrorMessage() {
            assertThat(String.format("The map doesn't contain the key: %s", KEY), map, hasKey(KEY));
        }

        @Test
        @DisplayName("Should not contain the incorrect key")
        void shouldNotContainIncorrectKey() {
            assertThat(map, not(hasKey(INCORRECT_KEY)));
        }

        @Test
        @DisplayName("Should not contain the incorrect key (with custom error message)")
        void shouldNotContainIncorrectKeyWithCustomErrorMessage() {
            assertThat(String.format("The map contains the key: %s", INCORRECT_KEY), map, not(hasKey(INCORRECT_KEY)));
        }
    }

    @Nested
    @DisplayName("When we check if the map contains the correct value")
    class WhenWeCheckIfMapContainsCorrectValue {

        @Test
        @DisplayName("Should contain the correct value")
        void shouldContainCorrectValue() {
            assertThat(map, hasEntry(KEY, VALUE));
        }
    }

    @Nested
    @DisplayName("When we get a value from the map")
    class WhenWeGetValueFromMap {

        @Nested
        @DisplayName("When the value is found")
        class WhenValueIsFound {

            @Test
            @DisplayName("Should return the found value")
            void shouldReturnFoundValue() {
                final String returned = map.get(KEY);
                assertThat(returned, is(VALUE));
            }

            @Test
            @DisplayName("Should return the found value (with custom error message)")
            void shouldReturnFoundValueWithCustomErrorMessage() {
                final String returned = map.get(KEY);
                assertThat("The map returned an incorrect value", returned, is(VALUE));
            }
        }

        @Nested
        @DisplayName("When the value is not found")
        class WhenValueIsNotFound {

            @Test
            @DisplayName("Should return null")
            void shouldReturnNull() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat(returned, nullValue());
            }

            @Test
            @DisplayName("Should return null (with custom error message)")
            void shouldReturnNullWithCustomErrorMessage() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat("The map didn't return null", returned, nullValue());
            }
        }
    }
}
