package net.petrikainulainen.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class demonstrates how we can group assertions by using
 * JUnit 5.
 *
 * @author Petri Kainulainen
 */
@DisplayName("Group multiple assertions")
class GroupAssertionsTest {

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
        assertAll("name",
                () -> assertEquals(FIRST_NAME, person.getFirstName(), "The first name is incorrect"),
                () -> assertEquals(LAST_NAME, person.getLastName(), "The last name is incorrect")
        );
    }
}
