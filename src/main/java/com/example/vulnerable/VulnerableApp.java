package com.example.vulnerable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.HashedMap;
import org.hibernate.validator.constraints.NotEmpty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * Vulnerable application demonstrating the use of outdated dependencies
 * with known security vulnerabilities.
 *
 * WARNING: This code is intentionally vulnerable and should NOT be used in production!
 */
public class VulnerableApp {

    private static final Logger logger = LogManager.getLogger(VulnerableApp.class);

    public static void main(String[] args) {
        logger.info("Starting vulnerable application...");

        // Using Log4j (vulnerable to Log4Shell)
        logger.info("Application initialized with Log4j 2.14.0");

        // Using Spring Framework
        String trimmed = StringUtils.trimWhitespace("  test  ");
        logger.info("Spring StringUtils: {}", trimmed);

        // Using Jackson for JSON processing
        ObjectMapper mapper = new ObjectMapper();
        logger.info("Jackson ObjectMapper initialized: {}", mapper.getClass().getName());

        // Using Apache Commons Collections
        Map<String, String> vulnerableMap = new HashedMap();
        vulnerableMap.put("status", "vulnerable");
        logger.info("Commons Collections Map: {}", vulnerableMap);

        // Using MySQL Connector
        try {
            Class.forName("com.mysql.jdbc.Driver");
            logger.info("MySQL Connector loaded (vulnerable version)");
        } catch (ClassNotFoundException e) {
            logger.error("MySQL Driver not found", e);
        }

        // Using H2 Database
        try {
            Class.forName("org.h2.Driver");
            logger.info("H2 Database driver loaded (vulnerable version)");
        } catch (ClassNotFoundException e) {
            logger.error("H2 Driver not found", e);
        }

        logger.info("Application running with multiple vulnerable dependencies!");
        logger.info("Total vulnerable dependencies: 10+");
    }

    /**
     * Example method using Hibernate Validator annotation
     */
    public String processInput(@NotEmpty String input) {
        return "Processed: " + input;
    }
}
