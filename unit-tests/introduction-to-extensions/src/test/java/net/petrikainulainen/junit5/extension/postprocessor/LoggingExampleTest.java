package net.petrikainulainen.junit5.extension.postprocessor;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This test class demonstrates how we can use the
 * {@link LoggerTestInstancePostProcessorExtension} extension
 * to inject a {@link Logger} object into our test object.
 */
@ExtendWith(LoggerTestInstancePostProcessorExtension.class)
class LoggingExampleTest {

    private Logger logger;

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll() method");
    }

    @BeforeEach
    void beforeEach() {
        logger.log("beforeEach() method");
    }

    @Test
    void testMethod() {
        logger.log("Test method");
    }

    @AfterEach
    void afterEach() {
        logger.log("afterEach() method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll() method");
    }
}
