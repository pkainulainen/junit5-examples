package net.petrikainulainen.junit5;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class demonstrates how we can group assertions by using
 * JUnit 5.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Collect all error messages before reporting them")
class SoftAssertionsTest {

    private static final String FIRST_NAME = "Jane";
    private static final String LAST_NAME = "Doe";

    private Person person;

    @BeforeEach
    void createPerson() {
        person = new Person();
        person.setFirstName(FIRST_NAME);
        person.setLastName(LAST_NAME);
    }

    @Test
    @DisplayName("Should have the correct name")
    void shouldHaveCorrectName() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(person.getFirstName())
                .overridingErrorMessage("Expected the first name to be: %s but it was: %s",
                        FIRST_NAME,
                        person.getFirstName()
                )
                .isEqualTo(FIRST_NAME);
        softAssertions.assertThat(person.getLastName())
                .overridingErrorMessage("Expected the last name to be: %s but it was: %s",
                        LAST_NAME,
                        person.getLastName()
                )
                .isEqualTo(LAST_NAME);

        softAssertions.assertAll();
    }
}
