package net.petrikainulainen.junit5.extension.postprocessor;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 *  This extension demonstrates how we can implement an extension which
 *  post processes the test object after it has been created. To be more
 *  specific, our extension injects a {@link Logger} object into the
 *  created test object.
 */
public class LoggerTestInstancePostProcessorExtension implements TestInstancePostProcessor {

    /**
     *  This method injects a new {@link Logger} object into the created
     *  test object IF the test class declares a {@link Logger} field.
     */
    @Override
    public void postProcessTestInstance(Object testInstance,
                                        ExtensionContext context) throws Exception {
        System.out.println("postProcessTestInstance()");
        Field loggerField = Arrays.stream(testInstance.getClass().getDeclaredFields())
                .filter(f -> f.getType().equals(Logger.class))
                .findFirst()
                .orElse(null);

        if (loggerField != null) {
            loggerField.setAccessible(true);
            loggerField.set(testInstance, new Logger());
        }
    }
}
