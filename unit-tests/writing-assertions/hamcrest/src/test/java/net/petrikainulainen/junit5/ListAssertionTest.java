package net.petrikainulainen.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This class demonstrates how we can write assertions for {@code List} objects
 * by using JUnit 5 and Hamcrest.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Writing assertions for lists")
class ListAssertionTest {

    @Nested
    @DisplayName("When we write assertions for elements")
    class WhenWeWriteAssertionsForElements {

        private final int EXPECTED_SIZE = 2;

        private Object first;
        private Object second;

        private List<Object> list;

        @BeforeEach
        void createAndInitializeList() {
            first = new Object();
            second = new Object();

            list = Arrays.asList(first, second);
        }

        @Test
        @DisplayName("Should contain two elements")
        void shouldContainTwoElements() {
            assertThat(list, hasSize(2));
        }

        @Test
        @DisplayName("Should contain two elements (with custom error message)")
        void shouldContainTwoElementsWithCustomErrorMessage() {
            assertThat(String.format("The size of the list was not %d", EXPECTED_SIZE), list, hasSize(2));
        }

        @Test
        @DisplayName("Should contain the correct elements in any order")
        void shouldContainCorrectElementsInAnyOrder() {
            assertThat(list, containsInAnyOrder(second, first));
        }

        @Test
        @DisplayName("Should contain the correct elements in any order (with custom error message)")
        void shouldContainCorrectElementsInAnyOrderWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the objects: %s and %s", first, second),
                    list,
                    containsInAnyOrder(second, first)
            );
        }

        @Test
        @DisplayName("Should contain the correct elements in the given order")
        void shouldContainCorrectElementsInGivenOrder() {
            assertThat(list, contains(first, second));
        }

        @Test
        @DisplayName("Should contain the correct elements in the given order(with custom error message)")
        void shouldContainCorrectElementsInGivenOrderWithCustomErrorMessage() {
            assertThat(String.format("The list doesn't contain the objects: %s and %s", first, second),
                    list,
                    contains(first, second)
            );
        }

        @Test
        @DisplayName("Should not contain an incorrect element")
        void shouldNotContainIncorrectElement() {
            assertThat(list, not(hasItem(new Object())));
        }

        @Test
        @DisplayName("Should not contain an incorrect element (with custom error message)")
        void shouldNotContainIncorrectElementWithCustomErrorMessage() {
            Object incorrect = new Object();
            assertThat(String.format("The list contains an incorrect object: %s", incorrect),
                    list,
                    not(hasItem(incorrect))
            );
        }
    }

    @Nested
    @DisplayName("When we compare two lists")
    class WhenWeCompareTwoLists {

        private final List<Integer> ACTUAL = Arrays.asList(1, 2, 3);
        private final List<Integer> EXPECTED = Arrays.asList(1, 2, 3);

        @Test
        @DisplayName("Should contain the same elements")
        void shouldContainSameElements() {
            assertThat(ACTUAL, is(EXPECTED));
        }

        @Test
        @DisplayName("Should contain the same elements (with custom error message)")
        void shouldContainSameElementsWithCustomErrorMessage() {
            assertThat("The lists don't contain the same elements", ACTUAL, is(EXPECTED));
        }
    }
}
