package net.petrikainulainen.junit5.extension.parameterresolver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class demonstrates how we can use the {@link MessageParameterResolverExtension}
 * extension when we register the extension at the method level.
 */
@ExtendWith(MessageParameterResolverExtension.class)
class MessageClassLevelExampleTest {

    /**
     *  Because only one test method takes a custom message as a method parameter,
     *  we can annotate only that method with the {@link ExtendWith} annotation.
     */
    @Test
    void messageTest(String message) {
        System.out.println("A test with resolved message argument");
        assertEquals("Hello World!", message);
    }

    @Test
    void testWithNoMessage() {
        System.out.println("A test with no message");
    }
}
