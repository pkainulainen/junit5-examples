package net.petrikainulainen.junit5.extension.predestroycallback;

import net.petrikainulainen.junit5.extension.lifecyclecallback.BeforeAfterAllCallbackExtension;
import net.petrikainulainen.junit5.extension.lifecyclecallback.BeforeAfterEachCallbackExtension;
import net.petrikainulainen.junit5.extension.lifecyclecallback.BeforeAfterTestExecutionCallbackExtension;
import net.petrikainulainen.junit5.extension.postprocessor.Logger;
import net.petrikainulainen.junit5.extension.postprocessor.LoggerTestInstancePostProcessorExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This example demonstrates how we can use our custom lifecycle
 * callback extension and helps us to see the execution order
 * of setup methods, teardown methods, test methods, and the callback
 * methods when we register our extensions at the class level.
 */
@ExtendWith({
        BeforeAfterAllCallbackExtension.class,
        BeforeAfterEachCallbackExtension.class,
        BeforeAfterTestExecutionCallbackExtension.class,
        LoggerTestInstancePostProcessorExtension.class,
        TestInstancePreDestroyExtension.class
})
class TestInstancePreDestroyExampleTest {

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
