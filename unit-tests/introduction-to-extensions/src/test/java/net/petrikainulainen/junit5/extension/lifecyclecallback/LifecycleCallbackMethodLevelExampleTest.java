package net.petrikainulainen.junit5.extension.lifecyclecallback;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This example demonstrates how we can use our custom lifecycle
 * callback extension and helps us to see the execution order
 * of setup methods, teardown methods, test methods, and the callback
 * methods when we register our extensions at both class and method level.
 */
@ExtendWith(BeforeAfterAllCallbackExtension.class)
class LifecycleCallbackMethodLevelExampleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll() method");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach() method");
    }

    @Test
    @ExtendWith({
            BeforeAfterEachCallbackExtension.class,
            BeforeAfterTestExecutionCallbackExtension.class
    })
    void testMethod() {
        System.out.println("Test method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach() method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll() method");
    }
}
