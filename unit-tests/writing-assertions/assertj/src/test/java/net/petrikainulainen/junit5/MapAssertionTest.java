package net.petrikainulainen.junit5;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for maps
 * by using AssertJ.
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
    @DisplayName("When we verify that the map contains the given key")
    class WhenWeVerifyThatMapContainsGivenKey {

        @Test
        @DisplayName("Should contain the correct key")
        void shouldContainCorrectKey() {
            assertThat(map).containsKey(KEY);
        }

        @Test
        @DisplayName("Should contain the correct key (with custom error message)")
        void shouldContainCorrectKeyWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage("The map doesn't contain the key: %s", KEY)
                    .containsKey(KEY);
        }

        @Test
        @DisplayName("Should not contain the incorrect key")
        void shouldNotContainIncorrectKey() {
            assertThat(map).doesNotContainKey(INCORRECT_KEY);
        }

        @Test
        @DisplayName("Should not contain the incorrect key (with custom error message)")
        void shouldNotContainIncorrectKeyWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage("The map contains the key: %s", INCORRECT_KEY)
                    .doesNotContainKey(INCORRECT_KEY);
        }
    }

    @Nested
    @DisplayName("When we verify that the map contains the correct value")
    class WhenWeVerifyThatMapContainsCorrectValue {

        @Test
        @DisplayName("Should contain the correct value")
        void shouldContainCorrectValue() {
            assertThat(map).containsEntry(KEY, VALUE);
        }

        @Test
        @DisplayName("Should contain the correct value (with custom error message)")
        void shouldContainCorrectValueWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage(
                            "The map didn't contain the value: %s for the key: %s",
                            VALUE,
                            KEY
                    )
                    .containsEntry(KEY, VALUE);
        }
    }

    @Nested
    @DisplayName("When we verify that the map doesn't contain the given value by using an incorrect key")
    class WhenWeVerifyThatMapDoesNotContainGivenValueByUsingIncorrectKey {

        @Test
        @DisplayName("Should not contain the given value")
        void shouldContainCorrectValue() {
            assertThat(map).doesNotContainEntry(INCORRECT_KEY, VALUE);
        }

        @Test
        @DisplayName("Should contain the given value (with custom error message)")
        void shouldContainCorrectValueWithCustomErrorMessage() {
            assertThat(map)
                    .overridingErrorMessage(
                            "Expected the map to not contain the value: %s for the key: %s but it containeds it",
                            VALUE,
                            KEY
                    )
                    .doesNotContainEntry(KEY, VALUE);
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
                assertThat(returned).isEqualTo(VALUE);
            }

            @Test
            @DisplayName("Should return the found value (with custom error message)")
            void shouldReturnFoundValueWithCustomErrorMessage() {
                final String returned = map.get(KEY);
                assertThat(returned)
                        .overridingErrorMessage(
                                "Expected the map to return: %s by using the key: %s but it returned: %s",
                                VALUE,
                                KEY,
                                returned
                        )
                        .isEqualTo(VALUE);
            }
        }

        @Nested
        @DisplayName("When the value is not found")
        class WhenValueIsNotFound {

            @Test
            @DisplayName("Should return null")
            void shouldReturnNull() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat(returned).isNull();
            }

            @Test
            @DisplayName("Should return null (with custom error message)")
            void shouldReturnNullWithCustomErrorMessage() {
                final String returned = map.get(INCORRECT_KEY);
                assertThat(returned)
                        .overridingErrorMessage(
                                "Expected the map to return null for the key: %s but it returned: %s",
                                KEY,
                                returned
                        )
                        .isNull();
            }
        }
    }
}
