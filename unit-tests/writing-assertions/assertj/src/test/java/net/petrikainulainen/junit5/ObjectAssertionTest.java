package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates how we can write assertions for objects
 * by using AssertJ.
 */
@DisplayName("Writing assertions for objects")
class ObjectAssertionTest {

    @Nested
    @DisplayName("When object is null")
    class WhenObjectIsNull {

        private final Object OBJECT = null;

        @Test
        @DisplayName("Should be null")
        void shouldBeNull() {
            assertThat(OBJECT).isNull();
        }

        @Test
        @DisplayName("Should be null (with custom error message)")
        void shouldBeNullWithCustomErrorMessage() {
            assertThat(OBJECT)
                    .overridingErrorMessage("Expected object to be null but it was: %s", OBJECT)
                    .isNull();
        }
    }

    @Nested
    @DisplayName("When object is not null")
    class WhenObjectIsNotNotNull {

        private final Object NOT_NULL = new Object();

        @Test
        @DisplayName("Should not be null")
        void shouldNotBeNull() {
            assertThat(NOT_NULL).isNotNull();
        }

        @Test
        @DisplayName("Should not be null (with custom error message)")
        void shouldNotBeNullWithCustomErrorMessage() {
            assertThat(NOT_NULL)
                    .overridingErrorMessage("Expected the object to be not null but it was null")
                    .isNotNull();
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
                assertThat(ACTUAL).isEqualByComparingTo(EXPECTED);
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected the integer to be: %d but it was: %d",
                                EXPECTED,
                                ACTUAL
                        )
                        .isEqualByComparingTo(EXPECTED);
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
                assertThat(ACTUAL).isEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Should be equal (with custom error message)")
            void shouldBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected the object to be: %s but it was: %s",
                                EXPECTED,
                                ACTUAL
                        )
                        .isEqualTo(EXPECTED);
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
                assertThat(ACTUAL).isNotEqualByComparingTo(EXPECTED);
            }

            @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected the integer: %d to not be equal to the integer: %d but they were equal",
                                ACTUAL,
                                EXPECTED
                        )
                        .isNotEqualByComparingTo(EXPECTED);
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
                assertThat(ACTUAL).isNotEqualTo(EXPECTED);
            }

            @Test
            @DisplayName("Should not be equal (with custom error message)")
            void shouldNotBeEqualWithCustomErrorMessage() {
                assertThat(ACTUAL)
                        .overridingErrorMessage(
                                "Expected that the string: %s is not equal to the string: %s but they were equal",
                                ACTUAL,
                                EXPECTED
                        )
                        .isNotEqualTo(EXPECTED);
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
            assertThat(ACTUAL).isSameAs(EXPECTED);
        }

        @Test
        @DisplayName("Should refer to the same object (with custom error message)")
        void shouldReferToSameErrorObjectWithCustomErrorMessage() {
            assertThat(ACTUAL)
                    .overridingErrorMessage("The objects don't refer to the same object")
                    .isSameAs(EXPECTED);
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
            assertThat(ACTUAL).isNotSameAs(EXPECTED);
        }

        @Test
        @DisplayName("Should not refer to the same object (with custom error message)")
        void shouldNotReferToSameObjectWithCustomErrorMessage() {
            assertThat(ACTUAL)
                    .overridingErrorMessage("The objects refer to the same objects")
                    .isNotSameAs(EXPECTED);
        }
    }
}
