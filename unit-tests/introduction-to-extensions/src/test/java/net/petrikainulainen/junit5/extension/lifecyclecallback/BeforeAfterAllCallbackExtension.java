package net.petrikainulainen.junit5.extension.lifecyclecallback;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 *  This extension demonstrates how we can implement a custom extension
 *  that's invoked before the setup method annotated with the
 *  {@link org.junit.jupiter.api.BeforeAll} annotation is run and
 *  after the teardown method annotated with the
 *  {@link org.junit.jupiter.api.AfterAll} annotation has been run.
 *
 *  Note that an extension which implements either the {@link AfterAllCallback}
 *  or the {@link BeforeAllCallback} interfaces must be registed at the class
 *  level. If this extensions is registered at the method level, it's simply
 *  ignored by JUnit 5.
 */
public class BeforeAfterAllCallbackExtension implements AfterAllCallback, BeforeAllCallback {

    /**
     * This callback is invoked after the teardown method annotated with the
     *  {@link org.junit.jupiter.api.AfterAll} annotation has been run.
     */
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("afterAll() callback");
    }

    /**
     * This callback is invoked before the setup method annotated with the
     *  {@link org.junit.jupiter.api.BeforeAll} annotation is run.
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("beforeAll() callback");
    }
}
