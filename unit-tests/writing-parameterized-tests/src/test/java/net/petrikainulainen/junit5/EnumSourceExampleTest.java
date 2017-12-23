package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Pass enum values to our test method")
class EnumSourceExampleTest {

    @DisplayName("Should pass non-null enum values as method parameters")
    @ParameterizedTest(name = "{index} => pet=''{0}''")
    @EnumSource(Pet.class)
    void shouldPassNonNullEnumValuesAsMethodParameter(Pet pet) {
        assertNotNull(pet);
    }

    @DisplayName("Should pass only the specified enum value as a method parameter")
    @ParameterizedTest(name = "{index} => pet=''{0}''")
    @EnumSource(value = Pet.class, names = {"CAT"})
    void shouldPassNonNullEnumValueAsMethodParameter(Pet pet) {
        assertNotNull(pet);
    }
}
