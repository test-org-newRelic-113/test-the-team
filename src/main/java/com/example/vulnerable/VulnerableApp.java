package com.example.vulnerable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.text.StringSubstitutor;
import org.hibernate.validator.constraints.NotEmpty;
import com.thoughtworks.xstream.XStream;
import org.yaml.snakeyaml.Yaml;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.apache.velocity.app.VelocityEngine;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.DocumentHelper;
import org.springframework.web.servlet.DispatcherServlet;
import java.security.Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.HashMap;

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

        // Using Apache Commons Text (vulnerable to Text4Shell)
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("key", "value");
        StringSubstitutor substitutor = new StringSubstitutor(valuesMap);
        String result = substitutor.replace("Text interpolation with ${key}");
        logger.info("Commons Text StringSubstitutor result: {}", result);

        // Using XStream (RCE via deserialization - CVE-2021-29505)
        XStream xstream = new XStream();
        logger.info("XStream initialized (vulnerable to RCE): {}", xstream.getClass().getName());

        // Using SnakeYAML (unsafe deserialization - CVE-2022-1471)
        Yaml yaml = new Yaml();
        logger.info("SnakeYAML initialized (unsafe deserialization): {}", yaml.getClass().getName());

        // Using Apache Shiro (authentication bypass - CVE-2016-4437, CVE-2020-1957)
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        logger.info("Apache Shiro SecurityManager initialized (auth bypass): {}", securityManager.getClass().getName());

        // Using Bouncy Castle (password verification bypass - CVE-2020-28052)
        Security.addProvider(new BouncyCastleProvider());
        logger.info("Bouncy Castle provider registered (vulnerable version 1.65)");

        // Using Apache Velocity (SSTI/RCE - CVE-2020-13936)
        VelocityEngine velocityEngine = new VelocityEngine();
        logger.info("Apache Velocity engine initialized (SSTI vulnerable): {}", velocityEngine.getClass().getName());

        // Using Fastjson (RCE via deserialization - CVE-2019-14540)
        logger.info("Fastjson version loaded: {}", JSON.VERSION);

        // Using Commons BeanUtils (class traversal - CVE-2019-10086)
        logger.info("Commons BeanUtils loaded: {}", BeanUtils.class.getName());

        // Using dom4j (XXE injection - CVE-2018-1000632)
        logger.info("dom4j DocumentHelper loaded: {}", DocumentHelper.class.getName());

        // Using Spring WebMVC (Spring4Shell RCE - CVE-2022-22965)
        logger.info("Spring WebMVC DispatcherServlet loaded: {}", DispatcherServlet.class.getName());

        logger.info("Application running with multiple vulnerable dependencies!");
        logger.info("Total vulnerable dependencies: 21");
    }

    /**
     * Example method using Hibernate Validator annotation
     */
    public String processInput(@NotEmpty String input) {
        return "Processed: " + input;
    }
}
