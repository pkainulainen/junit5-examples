package net.petrikainulainen.junit5.extension.executioncondition;

import org.junit.jupiter.api.Test;

class ExecutionConditionExampleTest {

    @Test
    void shouldBeRun() {
        System.out.println("This test method should be run");
    }

    @Test
    @DisableTest
    void shouldNotBeRun() {
        System.out.println("This test method shouldn't be run");
    }
}
