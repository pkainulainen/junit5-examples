package net.petrikainulainen.junit5.extension.lifecyclecallback;

import org.junit.jupiter.api.extension.*;

/**
 *  This extension demonstrates how we can implement a custom extension
 *  that's invoked before the setup method annotated with the
 *  {@link org.junit.jupiter.api.BeforeEach} annotation is run and
 *  after the teardown method annotated with the
 *  {@link org.junit.jupiter.api.AfterEach} annotation has been run.
 *
 *  Note that an extension which implements either the {@link AfterEachCallback}
 *  or the {@link BeforeEachCallback} interfaces can be registered at the class
 *  or method level.
 */
public class BeforeAfterEachCallbackExtension implements AfterEachCallback, BeforeEachCallback {

    /**
     * This callback is invoked after the teardown method annotated with the
     *  {@link org.junit.jupiter.api.AfterEach} annotation has been run.
     */
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("afterEach() callback");
    }

    /**
     * This callback is invoked before the setup method annotated with the
     *  {@link org.junit.jupiter.api.BeforeEach} annotation is run.
     */
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("beforeEach() callback");
    }
}
