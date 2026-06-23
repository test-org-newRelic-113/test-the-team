package com.example.vulnerable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.HashedMap;
import com.thoughtworks.xstream.XStream;
import org.yaml.snakeyaml.Yaml;
import org.apache.shiro.mgt.DefaultSecurityManager;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.DocumentHelper;
import org.springframework.web.servlet.DispatcherServlet;
import org.apache.commons.text.StringSubstitutor;
import org.apache.velocity.app.VelocityEngine;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.thymeleaf.TemplateEngine;
import groovy.lang.GroovyShell;
import org.jsoup.Jsoup;
import com.google.common.io.Files;
import net.sf.ehcache.CacheManager;
import org.apache.commons.io.FileUtils;
import java.security.Security;
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

        // Using XStream (RCE via deserialization - CVE-2021-29505)
        XStream xstream = new XStream();
        logger.info("XStream initialized (vulnerable to RCE): {}", xstream.getClass().getName());

        // Using SnakeYAML (unsafe deserialization - CVE-2022-1471)
        Yaml yaml = new Yaml();
        logger.info("SnakeYAML initialized (unsafe deserialization): {}", yaml.getClass().getName());

        // Using Apache Shiro (authentication bypass - CVE-2016-4437, CVE-2020-1957)
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        logger.info("Apache Shiro SecurityManager initialized (auth bypass): {}", securityManager.getClass().getName());

        // Using Fastjson (RCE via deserialization - CVE-2019-14540)
        logger.info("Fastjson version loaded: {}", JSON.VERSION);

        // Using Commons BeanUtils (class traversal - CVE-2019-10086)
        logger.info("Commons BeanUtils loaded: {}", BeanUtils.class.getName());

        // Using dom4j (XXE injection - CVE-2018-1000632)
        logger.info("dom4j DocumentHelper loaded: {}", DocumentHelper.class.getName());

        // Using Spring WebMVC (Spring4Shell RCE - CVE-2022-22965)
        logger.info("Spring WebMVC DispatcherServlet loaded: {}", DispatcherServlet.class.getName());

        // Using Apache Commons Text (Text4Shell - CVE-2022-42889)
        logger.info("Commons Text StringSubstitutor loaded: {}", StringSubstitutor.class.getName());

        // Using Apache Velocity (SSTI - CVE-2020-13936)
        VelocityEngine velocityEngine = new VelocityEngine();
        logger.info("Apache Velocity engine initialized (SSTI): {}", velocityEngine.getClass().getName());

        // Using Bouncy Castle (password bypass - CVE-2020-28052)
        Security.addProvider(new BouncyCastleProvider());
        logger.info("Bouncy Castle provider registered (vulnerable 1.65)");

        // Using Thymeleaf (SSTI - CVE-2021-43466)
        TemplateEngine templateEngine = new TemplateEngine();
        logger.info("Thymeleaf TemplateEngine initialized (SSTI): {}", templateEngine.getClass().getName());

        // Using Groovy (unsafe deserialization RCE - CVE-2016-6814)
        GroovyShell groovyShell = new GroovyShell();
        logger.info("Groovy GroovyShell initialized (unsafe deserialization): {}", groovyShell.getClass().getName());

        // Using PostgreSQL JDBC (SQL injection via properties - CVE-2022-21724)
        logger.info("PostgreSQL JDBC driver loaded (SQL injection via connection properties)");

        // Using Quartz Scheduler (XXE injection - CVE-2019-13990)
        logger.info("Quartz Scheduler loaded (XXE injection vulnerable)");

        // Using c3p0 (XXE/RCE via JNDI - CVE-2019-5427)
        logger.info("c3p0 connection pool loaded (XXE/RCE via JNDI)");

        // Using Woodstox (DoS via stack overflow - CVE-2022-40152)
        logger.info("Woodstox XML parser loaded (DoS stack overflow)");

        // Using Jsoup (XSS sanitization bypass - CVE-2021-37714)
        logger.info("Jsoup loaded: {}", Jsoup.class.getName());

        // Using Apache PDFBox (infinite loop DoS - CVE-2018-8036)
        logger.info("Apache PDFBox loaded (infinite loop DoS)");

        // Using Guava (insecure temp directory - CVE-2020-8908)
        logger.info("Guava Files utility loaded: {}", Files.class.getName());

        // Using Ehcache (open redirect/SSRF - CVE-2019-10098)
        logger.info("Ehcache CacheManager loaded: {}", CacheManager.class.getName());

        // Using Apache Commons IO (path traversal - CVE-2021-29425)
        logger.info("Apache Commons IO FileUtils loaded: {}", FileUtils.class.getName());

        // Using Spring Data MongoDB (SpEL injection - CVE-2022-22980)
        logger.info("Spring Data MongoDB loaded (SpEL injection vulnerable)");

        logger.info("Application running with multiple vulnerable dependencies!");
        logger.info("Total vulnerable dependencies: 36");
    }
}
