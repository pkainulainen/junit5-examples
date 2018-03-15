package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class demonstrates how we can write assertions for objects
 * by using JUnit 5.
 */
@DisplayName("Writing assertions for objects")
class ObjectAssertionTest {

    @Nested
    @DisplayName("When object is null")
    class WhenObjectIsNull {

        @Test
        @DisplayName("Should be null")
        void shouldBeNull() {
            assertNull(null);
        }

        @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertNull(null, "The object is not null");
        }
    }

    @Nested
    @DisplayName("When object is not null")
    class WhenObjectIsNotNotNull {

        private final Object NOT_NULL = new Object();

        @Test
        @DisplayName("Should not be null")
        void shouldNotBeNull() {
            assertNotNull(NOT_NULL);
        }

        @Test
        @DisplayName("Should not be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertNotNull(NOT_NULL, "The object is null");
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
                assertEquals(EXPECTED, ACTUAL);
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertEquals(EXPECTED, ACTUAL, "The integers are not equal");
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
                assertEquals(EXPECTED, ACTUAL);
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertEquals(EXPECTED, ACTUAL, "The strings are not equal");
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
                    assertNotEquals(EXPECTED, ACTUAL);
                }

                @Test
                @DisplayName("Should not be equal (with custom error message)")
                void shouldNotBeEqualWithCustomErrorMessage() {
                    assertNotEquals(EXPECTED, ACTUAL, "The integers are equal");
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
                    assertNotEquals(EXPECTED, ACTUAL);
                }

                @Test
                @DisplayName("Should not be equal (with custom error message)")
                void shouldNotBeEqualWithCustomErrorMessage() {
                    assertNotEquals(EXPECTED, ACTUAL, "The strings are equal");
                }
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
            assertSame(EXPECTED, ACTUAL);
        }

        @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertSame(EXPECTED, ACTUAL, "Objects don't refer to the same object");
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
            assertNotSame(EXPECTED, ACTUAL);
        }

        @Test
        @DisplayName("Should not refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertNotSame(EXPECTED, ACTUAL, "Objects refer to the same object");
        }
    }
}
