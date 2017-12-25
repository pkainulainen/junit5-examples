package net.petrikainulainen.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Pass converted Pet enum values to our test method")
class PetConverterExampleTest {

    @DisplayName("Should pass correct Pet enum values as method parameters")
    @ParameterizedTest(name = "{index} => actual={0}, expected={1}")
    @CsvSource({
            "CAT, CAT",
            "DOG, DOG",
    })
    void shouldPassCorrectPetEnumValues(@ConvertWith(PetConverter.class) Pet actual,
                                        @ConvertWith(PetConverter.class) Pet expected) {
        assertEquals(expected, actual);
    }
}
