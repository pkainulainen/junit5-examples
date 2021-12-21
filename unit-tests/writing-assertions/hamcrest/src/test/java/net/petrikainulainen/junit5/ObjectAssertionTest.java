package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * This class demonstrates how we can write assertions for objects
 * by using JUnit 5 and Hamcrest.
 */
@DisplayName("Writing assertions for objects")
class ObjectAssertionTest {

    @Nested
    @DisplayName("When object is null")
    class WhenObjectIsNull {

        @Test
        @DisplayName("Should be null")
        void shouldBeNull() {
            assertThat(null, nullValue());
        }

        @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertThat("The object is not null", null, nullValue());
        }
    }

    @Nested
    @DisplayName("When object is not null")
    class WhenObjectIsNotNotNull {

        private final Object NOT_NULL = new Object();

        @Test
        @DisplayName("Should not be null")
        void shouldNotBeNull() {
            assertThat(NOT_NULL, notNullValue());
        }

        @Test
        @DisplayName("Should not be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertThat("The object is null", NOT_NULL, notNullValue());
        }
    }

    @Nested
    @DisplayName("When two objects are equal")
    class WhenTwoObjectsAreEqual {

        @Nested
        @DisplayName("When objects are integers")
        class WhenObjectsAreIntegers {

            private final Integer ACTUAL = 9;
            private final Integer EXPECTED = 9;

            @Test
            @DisplayName("Should be equal")
            void shouldBeEqual() {
                assertThat(ACTUAL, equalTo(EXPECTED));
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat("The integers are not equal", ACTUAL, equalTo(EXPECTED));
            }
        }

        @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

            private final String ACTUAL = "Foo";
            private final String EXPECTED = "Foo";

            @Test
            @DisplayName("Should be equal")
            void shouldBeEqual() {
                assertThat(ACTUAL, equalTo(EXPECTED));
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat("The strings are not equal", ACTUAL, equalTo(EXPECTED));
            }
        }
    }

    @Nested
    @DisplayName("When two objects aren't equal")
    class WhenTwoObjectsAreNotEqual {

        @Nested
        @DisplayName("When objects are integers")
        class WhenObjectsAreIntegers {

            private final Integer ACTUAL = 9;
            private final Integer EXPECTED = 4;

            @Test
            @DisplayName("Should not be equal")
            void shouldNotBeEqual() {
                assertThat(ACTUAL, not(EXPECTED));
            }

            @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat("The integers are equal", ACTUAL, not(EXPECTED));
            }
        }

        @Nested
        @DisplayName("When objects are strings")
        class WhenObjectsAreStrings {

            private final String ACTUAL = "Foo";
            private final String EXPECTED = "Bar";

            @Test
            @DisplayName("Should not be equal")
            void shouldNotBeEqual() {
                assertThat(ACTUAL, not(EXPECTED));
            }

            @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat("The strings are equal", ACTUAL, not(EXPECTED));
            }
        }
    }

    @Nested
    @DisplayName("When two objects refer to the same object")
    class WhenTwoObjectsReferToSameObject {

        private final Object ACTUAL = new Object();
        private final Object EXPECTED = ACTUAL;

        @Test
        @DisplayName("Should refer to the same object")
        void shouldReferToSameObject() {
            assertThat(ACTUAL, sameInstance(EXPECTED));
        }

        @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertThat("Objects don't refer to the same object", ACTUAL, sameInstance(EXPECTED));
        }
    }

    @Nested
    @DisplayName("When two objects don't refer to the same object")
    class WhenTwoObjectsDoNotReferToSameObject {

        private final Object ACTUAL = new Object();
        private final Object EXPECTED = new Object();

        @Test
        @DisplayName("Should not refer to the same object")
        void shouldNotReferToSameObject() {
           assertThat(ACTUAL, not(sameInstance(EXPECTED)));
        }

        @Test
        @DisplayName("Should not refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertThat("Objects refer to the same object", ACTUAL, not(sameInstance(EXPECTED)));
        }
    }
}
