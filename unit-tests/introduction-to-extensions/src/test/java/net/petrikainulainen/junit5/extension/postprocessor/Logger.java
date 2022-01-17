package net.petrikainulainen.junit5.extension.postprocessor;

/**
 * A "logger" which writes the log message to the {@code System.out}.
 */
public class Logger {

    public void log(String message) {
        System.out.println(message);
    }
}
