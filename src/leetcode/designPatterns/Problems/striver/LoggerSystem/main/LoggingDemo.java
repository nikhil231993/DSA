package leetcode.designPatterns.Problems.striver.LoggerSystem.main;

import leetcode.designPatterns.Problems.striver.LoggerSystem.appenders.ConsoleAppender;
import leetcode.designPatterns.Problems.striver.LoggerSystem.appenders.DatabaseAppender;
import leetcode.designPatterns.Problems.striver.LoggerSystem.appenders.FileAppender;
import leetcode.designPatterns.Problems.striver.LoggerSystem.core.LogLevel;
import leetcode.designPatterns.Problems.striver.LoggerSystem.core.LogMessage;
import leetcode.designPatterns.Problems.striver.LoggerSystem.core.Logger;
import leetcode.designPatterns.Problems.striver.LoggerSystem.core.LoggerImpl;
import leetcode.designPatterns.Problems.striver.LoggerSystem.filter.LevelFilter;
import leetcode.designPatterns.Problems.striver.LoggerSystem.fomatters.SimpleFormatter;

import java.time.Instant;

/**
 * Demo class to demonstrate the LoggingFramework functionality.
 * Shows different logging levels, appenders, formatters, and filters.
 */
public class LoggingDemo {

    public static void main(String[] args) {
        System.out.println("=== LoggingFramework Demo ===\n");

        // Demo 1: Basic logging with different levels
        demoBasicLogging();

        // Demo 2: Multiple appenders
        //demoMultipleAppenders();

        // Demo 3: Custom formatters
        // demoCustomFormatters();

        // Demo 4: Filters
        // demoFilters();

        // Demo 5: Thread safety
        // demoThreadSafety();

        System.out.println("\n=== Demo Complete ===");
    }

    private static void demoBasicLogging() {
        System.out.println("1. Basic Logging Demo:");
        System.out.println("----------------------");

        LogMessage message = new LogMessage.Builder()
                .source("Nikhil")
                .message("Test")
                .level(LogLevel.INFO)
                .timestamp(Instant.now())
                .build();


        Logger logger = new LoggerImpl("BasicLogger");

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        System.out.println();
    }

    private static void demoMultipleAppenders() {
        System.out.println("2. Multiple Appenders Demo:");
        System.out.println("---------------------------");

        Logger logger = new LoggerImpl("MultiAppenderLogger");

        // Add file appender
        FileAppender fileAppender = new FileAppender("demo.log");
        DatabaseAppender databaseAppender = new DatabaseAppender("LOG Table");
        logger.addAppender(fileAppender);
        logger.addAppender(databaseAppender);

        logger.info("This message goes to both console and file");
        logger.error("This error also goes to both destinations");

        System.out.println("Check 'demo.log' file for the logged messages");
        System.out.println();
    }

    private static void demoCustomFormatters() {
        System.out.println("3. Custom Formatters Demo:");
        System.out.println("--------------------------");

        Logger logger = new LoggerImpl("FormatterLogger");

        // Create custom formatter
        SimpleFormatter customFormatter = new SimpleFormatter("[%LEVEL] %TIMESTAMP - %MESSAGE");
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setFormatter(customFormatter);

        // Replace default console appender
        logger.addAppender(consoleAppender);

        logger.info("This message uses custom formatting");
        logger.error("This error also uses custom formatting");

        System.out.println();
    }

    private static void demoFilters() {
        System.out.println("4. Filters Demo:");
        System.out.println("----------------");

        Logger logger = new LoggerImpl("FilterLogger");

        // Add level filter - only show WARNING and above
        LevelFilter levelFilter = new LevelFilter(LogLevel.WARNING);
        logger.addFilter(levelFilter);

        logger.debug("This debug message will be filtered out");
        logger.info("This info message will be filtered out");
        logger.warning("This warning message will be shown");
        logger.error("This error message will be shown");

        System.out.println();
    }

    private static void demoThreadSafety() {
        System.out.println("5. Thread Safety Demo:");
        System.out.println("----------------------");

        Logger logger = new LoggerImpl("ThreadSafeLogger");

        // Create multiple threads logging simultaneously
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    logger.info("Thread " + threadId + " - Message " + j);
                    try {
                        Thread.sleep(10); // Small delay to increase concurrency
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All threads completed - check for any mixed-up messages above");
        System.out.println();
    }
}
