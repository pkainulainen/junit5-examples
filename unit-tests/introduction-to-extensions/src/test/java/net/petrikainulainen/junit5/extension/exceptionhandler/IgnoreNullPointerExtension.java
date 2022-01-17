package net.petrikainulainen.junit5.extension.exceptionhandler;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

/**
 * This extension demonstrates how we can implement an extension which handles
 * the exceptions thrown by a test method. To be more specific, our extension
 * swallows all {@link NullPointerException} objects and throws all other exceptions so that
 * they can be handled by subsequent {@link TestExecutionExceptionHandler} objects.
 *
 * Note that extensions which implement the {@link TestExecutionExceptionHandler} interface
 * can be registered at the class and method level.
 */
public class IgnoreNullPointerExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("handling test execution exception: " + throwable.getClass().getSimpleName());
        if (throwable instanceof NullPointerException) {
            return;
        }

        throw throwable;
    }
}
