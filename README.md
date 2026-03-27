# Vulnerable Java Application for Dependabot Testing

**⚠️ WARNING: This application contains intentional security vulnerabilities and should NEVER be deployed to production!**

## Purpose

This project is designed to test Dependabot's ability to detect and report security vulnerabilities in Java dependencies.

## Vulnerable Dependencies

This project includes **10 intentionally vulnerable dependencies**:

### 1. **Log4j 2.14.0**
- **CVE-2021-44228** (Log4Shell) - Critical RCE vulnerability
- **CVE-2021-45046**, **CVE-2021-45105** - Additional Log4j vulnerabilities
- Severity: Critical

### 2. **Spring Framework 5.2.0**
- Multiple CVEs including directory traversal and RCE vulnerabilities
- Severity: High

### 3. **Jackson Databind 2.9.8**
- Multiple deserialization vulnerabilities
- Various CVEs related to unsafe deserialization
- Severity: High/Critical

### 4. **Apache Commons Collections 3.2.1**
- **CVE-2015-6420** - Remote code execution via deserialization
- Severity: Critical

### 5. **Apache Struts 2.5.10**
- Multiple RCE vulnerabilities
- Various CVEs affecting this version
- Severity: Critical

### 6. **Apache Tomcat Embed Core 8.5.0**
- Multiple security vulnerabilities
- Information disclosure and other issues
- Severity: Medium/High

### 7. **Hibernate Validator 5.2.0**
- Multiple CVEs including potential code execution
- Severity: Medium/High

### 8. **MySQL Connector Java 5.1.40**
- Multiple security vulnerabilities
- SSL/TLS and authentication issues
- Severity: Medium/High

### 9. **Apache Commons FileUpload 1.3.1**
- **CVE-2016-1000031** - Denial of Service vulnerability
- Severity: High

### 10. **H2 Database 1.4.196**
- **CVE-2018-10054**, **CVE-2018-14335** - Remote code execution
- Severity: Critical

## Building the Project

```bash
cd dependabot-test
mvn clean compile
```

## Running the Application

```bash
mvn exec:java -Dexec.mainClass="com.example.vulnerable.VulnerableApp"
```

## Testing Dependabot

1. Push this code to a GitHub repository
2. Enable Dependabot security alerts in the repository settings
3. Dependabot should detect and create alerts for all 10 vulnerable dependencies
4. Dependabot should create pull requests to update these dependencies to secure versions

## Security Recommendations (for fixing)

To fix these vulnerabilities, update to the following minimum versions:

- Log4j: 2.17.1 or later
- Spring Framework: 5.3.20 or later
- Jackson Databind: 2.13.4 or later
- Apache Commons Collections: 3.2.2 or use Collections4
- Apache Struts: 2.5.30 or later
- Apache Tomcat: 8.5.78 or later
- Hibernate Validator: 6.2.3 or later
- MySQL Connector: 8.0.28 or later
- Apache Commons FileUpload: 1.3.3 or later
- H2 Database: 2.1.210 or later

## Disclaimer

This code is for educational and testing purposes only. It should never be used in any production environment or with real user data.