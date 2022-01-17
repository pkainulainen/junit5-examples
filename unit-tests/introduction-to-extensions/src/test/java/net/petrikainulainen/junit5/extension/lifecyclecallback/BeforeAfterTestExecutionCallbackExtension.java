package net.petrikainulainen.junit5.extension.lifecyclecallback;

import org.junit.jupiter.api.extension.*;

/**
 * This extension demonstrates how we can implement an extension
 * that's invoked before a test method is run and after a test
 * method has been run.
 *
 * Note that an extensions which implements either the
 * {@link AfterTestExecutionCallback} or {@link BeforeTestExecutionCallback}
 * interface can be registered at the class or method level.
 */
public class BeforeAfterTestExecutionCallbackExtension implements AfterTestExecutionCallback,
        BeforeTestExecutionCallback {

    /**
     * This callback method is invoked after a test method has been run.
     */
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("afterTestExecution() callback");
    }

    /**
     * This callback method is invoked before a test method is run.
     */
    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("beforeTestExecution() callback");
    }
}
