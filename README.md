# REST Assured API Automation Framework

A comprehensive, production-ready REST API automation testing framework built with **REST Assured** and **TestNG**. This framework follows design patterns and best practices for automating API tests with a focus on maintainability, scalability, and code reusability.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running Tests](#running-tests)
- [Configuration](#configuration)
- [Architecture & Design Patterns](#architecture--design-patterns)
- [Key Components](#key-components)
- [Test Examples](#test-examples)
- [Logging & Reports](#logging--reports)
- [Best Practices](#best-practices)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

---

## 📖 Project Overview

This REST Assured API Automation Framework is designed to automate testing of RESTful APIs with a focus on:

- **Modular Architecture**: Separation of concerns using BaseService, AuthService, and specific service classes
- **Request/Response Models**: Strongly-typed POJO classes for request payloads and response objects
- **Reusable Components**: Custom filters, listeners, and utilities for common testing scenarios
- **Logging & Reporting**: Comprehensive logging using Log4j2 and TestNG reporting capabilities
- **Data-Driven Testing**: Support for parameterized tests using TestNG

The framework is designed to test authentication-based APIs and user profile management endpoints.

---

## ✨ Features

✅ **Service-Oriented Architecture** - Organized test services (AuthService, UserService, etc.)  
✅ **Request/Response Serialization** - Automatic POJO deserialization using Jackson  
✅ **Custom Logging Filter** - Logs all requests and responses automatically  
✅ **Extent Reports Integration** - Advanced HTML reporting with ExtentReportManager listener  
✅ **Parameterized Tests** - Data-driven testing capabilities with DataProviders  
✅ **Bearer Token Authentication** - Support for token-based authentication  
✅ **Multiple HTTP Methods** - GET, POST, PUT, DELETE request support  
✅ **Comprehensive Assertions** - TestNG assertions for validation  
✅ **Log4j2 Integration** - File and console logging with customizable patterns  
✅ **Thread-Safe Execution** - Support for parallel test execution  
✅ **JavaFaker Integration** - Dynamic test data generation  
✅ **Lombok Support** - Reduced boilerplate code with annotations  
✅ **Excel Data Integration** - Apache POI for Excel test data management  
✅ **Petstore API Support** - Pre-configured endpoints for Petstore Swagger API  
✅ **Dual API Support** - Authentication API and Petstore API endpoints  

---

## 🛠️ Technology Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| **REST Assured** | 6.0.0 | REST API testing library |
| **TestNG** | 7.11.0 | Test framework & assertions |
| **Jackson** | 2.18.2 | JSON serialization/deserialization |
| **Log4j2** | 2.20.0 | Logging framework |
| **Extent Reports** | 5.0.9 | Advanced test reporting & HTML reports |
| **Apache POI** | 5.4.1 | Excel file handling (test data) |
| **JavaFaker** | 1.0.2 | Test data generation & random values |
| **Lombok** | 1.18.30 | Boilerplate code generation (@Getter, @Setter, @Data) |
| **Maven** | Latest | Build automation |
| **Java** | 21 | Programming language |

---

## 📁 Project Structure

```
RestAssured-API-Automation/
├── pom.xml                                    # Maven configuration and dependencies
├── suite.xml                                  # TestNG suite configuration
├── TestData.xlsx                              # Excel test data file
├── logs/
│   └── test.log                              # Test execution logs
├── src/
│   ├── main/
│   │   ├── java/                             # Main source code (if needed)
│   │   └── resources/                        # Main resources
│   └── test/
│       ├── java/
│       │   ├── api/                          # API-specific endpoints and payloads
│       │   │   ├── endpoints/                # API endpoint routes
│       │   │   │   ├── Routes.java           # Routes (base URLs and endpoints)
│       │   │   │   ├── UserEndPoints.java    # User API endpoints
│       │   │   │   └── UserEndPoints2.java   # Alternative user endpoints
│       │   │   └── payload/
│       │   │       └── User.java             # User payload POJO
│       │   └── com/api/                      # Core API testing framework
│       │       ├── base/                     # Base classes for API testing
│       │       │   ├── BaseService.java      # Abstract base for all services
│       │       │   ├── AuthService.java      # Authentication API service
│       │       │   └── UserService.java      # User profile API service
│       │       ├── models/                   # Request/Response POJOs
│       │       │   ├── request/
│       │       │   │   ├── LoginRequest.java
│       │       │   │   ├── SignupRequest.java
│       │       │   │   └── UpdateProfileRequest.java
│       │       │   └── response/
│       │       │       ├── LoginResponse.java
│       │       │       └── UserProfileResponse.java
│       │       ├── filters/                  # Custom RestAssured filters
│       │       │   └── LoggingFilter.java    # Logs all requests/responses
│       │       ├── utilities/                # Utility classes for tests
│       │       │   ├── ExtentReportManager.java   # Extent Reports implementation
│       │       │   ├── DataProviders.java    # TestNG data providers
│       │       │   └── ExcelUtility.java     # Excel file utilities
│       │       ├── listeners/                # TestNG listeners
│       │       │   └── TestListenner.java    # Test lifecycle listener
│       │       └── tests/                    # Test classes
│       │           ├── LoginAPITest.java
│       │           ├── LoginAPITestOptimized.java
│       │           ├── LoginAPITestEnhanced.java
│       │           ├── SignupAPITest.java
│       │           ├── GetProfileAPITest.java
│       │           ├── UpdateProfileTest.java
│       │           ├── ForgotPasswordAPITest.java
│       │           ├── DataDrivenTests.java  # Parameterized data-driven tests
│       │           ├── UserTests.java
│       │           └── UserTests2.java
│       └── resources/
│           ├── log4j2.xml                    # Log4j2 configuration
│           └── routes.properties             # Route configurations
├── target/                                    # Build output directory
│   ├── classes/
│   ├── test-classes/
│   ├── generated-sources/
│   └── surefire-reports/                     # Maven Surefire test reports
├── test-output/                              # Extent Reports and TestNG reports
│   ├── index.html                            # TestNG HTML report
│   ├── emailable-report.html                 # Email-friendly report
│   ├── Automation-Report-*.html              # Extent HTML Reports
│   ├── testng-results.xml                    # XML test results
│   └── ... (other reports)
└── README.md                                  # This file
```

---

## 📋 Prerequisites

Before setting up the project, ensure you have:

- **Java 21 or higher** installed
- **Maven 3.6 or higher** installed
- **Git** installed (for version control)
- **IDE** (Eclipse, IntelliJ IDEA, or VS Code recommended)
- **Network access** to the API server: `http://64.227.160.186:8080`

### Verify Installations

```cmd
java -version
mvn --version
git --version
```

---

## 🚀 Installation & Setup

### Step 1: Clone the Repository

```cmd
git clone <repository-url>
cd RestAssured-API-Automation
```

### Step 2: Update Maven Dependencies

```cmd
mvn clean install
```

This command will:
- Clean any previous builds
- Download all dependencies from pom.xml
- Compile the project

### Step 3: Verify Setup

```cmd
mvn -v
```

### Step 4: Import into IDE

**For Eclipse:**
1. Open Eclipse
2. File → Import → Existing Maven Projects
3. Select the project directory
4. Click Finish

**For IntelliJ IDEA:**
1. Open IntelliJ IDEA
2. File → Open
3. Select the project directory
4. Click Open as Project

---

## ▶️ Running Tests

### Run All Tests

```cmd
mvn test
```

### Run Specific Test Class

```cmd
mvn test -Dtest=LoginAPITestOptimized
```

### Run with Specific Suite

```cmd
mvn test -Dsuite=suite.xml
```

### Run Tests with Custom Thread Count

```cmd
mvn test -Dthread-count=5
```

### Run Tests in Parallel

Modify `suite.xml` to enable parallel execution:

```xml
<suite name="REST ASSURED API Test suite" parallel="tests" thread-count="5">
```

Then run:

```cmd
mvn test
```

### View Test Results

After execution, test reports are available at:

- **TestNG Report**: `test-output/index.html`
- **Email Report**: `test-output/emailable-report.html`
- **Maven Report**: `target/surefire-reports/`

Open these HTML files in a browser to view detailed test results.

---

## ⚙️ Configuration

### API Base URL

The framework supports two sets of APIs:

**1. Authentication & Custom APIs** - Located in `BaseService.java`:

```java
private static final String BASE_URL = "http://64.227.160.186:8080";
```

To change this API endpoint:

```java
private static final String BASE_URL = "http://your-api-url:port";
```

**2. Petstore Swagger APIs** - Located in `api/endpoints/Routes.java`:

```java
public static String base_url = "https://petstore.swagger.io/v2";

// User Module endpoints
public static String post_url = base_url + "/user";        // POST /user
public static String put_url = base_url + "/user/{username}";   // PUT /user/{username}
public static String get_url = base_url + "/user/{username}";   // GET /user/{username}
public static String delete_url = base_url + "/user/{username}"; // DELETE /user/{username}
```

### Logging Configuration

Logging is configured in `src/test/resources/log4j2.xml`:

```xml
<Configuration status="WARN">
    <Appenders>
        <!-- Console appender for console output -->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        
        <!-- File appender for file logging -->
        <File name="File" fileName="logs/test.log">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="File"/>
        </Root>
    </Loggers>
</Configuration>
```

**Pattern Elements:**
- `%d{HH:mm:ss.SSS}` - Timestamp (hours, minutes, seconds, milliseconds)
- `[%t]` - Thread name in square brackets (single-threaded: "main")
- `%-5level` - Log level padded to 5 characters for alignment
- `%logger{36}` - Class name (truncated to 36 characters)
- `%msg` - Log message
- `%n` - New line

### Extent Reports Configuration

Extent Reports generates advanced HTML reports. Configuration is in `ExtentReportManager.java`:

The reports are generated with:
- Timestamp in filename: `Automation-Report-{timestamp}.html`
- Location: `test-output/` directory
- Theme: Standard Extent Reports theme
- Detailed logs and pass/fail status for each test

### TestNG Suite Configuration

Modify `suite.xml` to control test execution:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="REST ASSURED API Test suite">
  <listeners>
    <listener class-name="com.api.utilities.ExtentReportManager"/>
  </listeners>
  <test thread-count="5" name="API Test">
    <classes>
      <class name="com.api.tests.LoginAPITestOptimized"/>
      <!-- Add more test classes -->
    </classes>
  </test>
</suite>
```

**Configuration Options:**
- `thread-count` - Number of threads for parallel execution
- `listeners` - Test listeners (ExtentReportManager for Extent Reports)
- `classes` - Test classes to execute

---

## 🏗️ Architecture & Design Patterns

### 1. **Service Layer Pattern**

Tests use dedicated service classes for API operations:

```
BaseService (Abstract)
    ↓
    ├── AuthService (Authentication endpoints)
    ├── UserService (User profile endpoints)
    └── ... (Other specific services)
```

### 2. **Request/Response Models Pattern**

POJO classes for type-safe serialization/deserialization:

```java
// Request
LoginRequest request = new LoginRequest("username", "password");

// Response
LoginResponse response = restResponse.as(LoginResponse.class);
```

### 3. **Endpoint Routes Pattern**

Centralized API endpoint management in `Routes.java` and `UserEndPoints.java`:

```java
// Routes.java - Constants
public static String base_url = "https://petstore.swagger.io/v2";
public static String post_url = base_url + "/user";

// UserEndPoints.java - Endpoint methods
public class UserEndPoints {
    public static Response createUser(User payload) {
        return given().body(payload).post(Routes.post_url);
    }
}
```

### 4. **Filter Pattern**

Custom logging filter intercepts all requests/responses:

```java
filters(new LoggingFilter());  // Applied globally in BaseService
```

### 5. **Listener Pattern**

TestNG listeners track test execution lifecycle:

```java
// Registered in suite.xml
<listener class-name="com.api.utilities.ExtentReportManager"/>
```

### 6. **Data Provider Pattern**

Parameterized tests using TestNG data providers:

```java
@Test(dataProvider = "loginCredentials", dataProviderClass = DataProviders.class)
public void testLogin(String username, String password) { ... }
```

---

## 🔑 Key Components

### BaseService.java

Abstract base class providing common API functionality:

```java
public class BaseService {
    private static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;
    
    static {
        // Static initializer block to apply LoggingFilter globally
        filters(new LoggingFilter());
    }
    
    public BaseService() {
        // Initialize RequestSpecification with base URI
        requestSpecification = given().baseUri(BASE_URL);
    }
    
    protected void setAuthToken(String token) {
        // Set Bearer token for authenticated requests
        requestSpecification.header("Authorization", "Bearer " + token);
    }
    
    protected Response postRequest(String endpoint, Object payload) {
        // Generic POST request method
        return requestSpecification.contentType(ContentType.JSON)
            .body(payload).post(endpoint);
    }
    
    protected Response getRequest(String endpoint) {
        // GET request method
        return requestSpecification.get(endpoint);
    }
    
    protected Response putRequest(String endpoint, Object payload) {
        // PUT request method
        return requestSpecification.contentType(ContentType.JSON)
            .body(payload).put(endpoint);
    }
}
```

### AuthService.java

Extends BaseService for authentication API operations:

```java
public class AuthService extends BaseService {
    private static final String BASE_PATH = "/api/auth/";
    
    public Response login(LoginRequest payload) {
        return postRequest(BASE_PATH + "login", payload);
    }
    
    public Response signup(SignupRequest payload) {
        return postRequest(BASE_PATH + "signup", payload);
    }
}
```

### UserEndPoints.java

Manages User API endpoints for Petstore API:

```java
public class UserEndPoints {
    // Uses Routes.java to construct URLs
    // Methods for POST, GET, PUT, DELETE operations on user endpoints
}
```

### Routes.java

Contains endpoint configurations for Petstore API:

```java
public class Routes {
    public static String base_url = "https://petstore.swagger.io/v2";
    
    // User Module endpoints
    public static String post_url = base_url + "/user";
    public static String put_url = base_url + "/user/{username}";
    public static String get_url = base_url + "/user/{username}";
    public static String delete_url = base_url + "/user/{username}";
}
```

### LoggingFilter.java

Custom filter for automatic request/response logging:

```java
public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
    
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, 
                          FilterableResponseSpecification responseSpec,
                          FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec);
        logResponse(response);
        return response;
    }
}
```

### ExtentReportManager.java

TestNG listener for generating Extent Reports:

```java
public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    
    @Override
    public void onStart(ITestContext testContext) {
        // Initialize Extent Reports with timestamped filename
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        // Log successful tests to report
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        // Log failed tests with failure details
    }
}
```

### DataProviders.java

Contains TestNG data providers for parameterized tests:

```java
public class DataProviders {
    @DataProvider
    public Object[][] getLoginCredentials() {
        // Return test data for login tests
    }
    
    @DataProvider
    public Object[][] getUserData() {
        // Return user data for user tests
    }
}
```

### ExcelUtility.java

Utility class for reading/writing Excel test data:

```java
public class ExcelUtility {
    // Methods to read data from Excel files (TestData.xlsx)
    // Methods to write test results to Excel
}
```

---

## 📝 Test Examples

### Example 1: Login API Test (Optimized)

```java
@Test(description = "Test the login API")
public void loginTestOptimized() {
    // Create request
    LoginRequest loginRequest = new LoginRequest("jaswanth", "Jaswanth@9999");
    
    // Call API using service
    AuthService authService = new AuthService();
    Response response = authService.login(loginRequest);
    
    // Deserialize response
    LoginResponse loginResponse = response.as(LoginResponse.class);
    
    // Print details
    System.out.println("Response: " + response.asPrettyString());
    System.out.println("Token: " + loginResponse.getToken());
    System.out.println("Username: " + loginResponse.getUsername());
    
    // Assertions
    Assert.assertEquals(loginResponse.getUsername(), "Jaswanth");
    Assert.assertEquals(response.getStatusCode(), 200);
}
```

### Example 2: Signup API Test

```java
@Test(description = "Test the signup API")
public void signupAPITest() {
    // Create request using builder pattern
    SignupRequest signupRequest = new SignupRequest.Builder()
        .setUsername("newuser1234")
        .setPassword("NewUser@1234")
        .setEmail("newuserr1234@gmail.com")
        .setFirstName("New")
        .setLastName("User")
        .setMobileNumber("1234567890")
        .build();
    
    // Call signup API
    AuthService authService = new AuthService();
    Response response = authService.signup(signupRequest);
    
    // Assertions
    System.out.println("Response: " + response.asPrettyString());
    Assert.assertEquals(response.getStatusCode(), 201);
}
```

### Example 3: Multiple Assertions

```java
@Test(description = "Comprehensive login test")
public void comprehensiveLoginTest() {
    LoginRequest request = new LoginRequest("testuser", "TestPass@123");
    AuthService authService = new AuthService();
    Response response = authService.login(request);
    
    LoginResponse loginResponse = response.as(LoginResponse.class);
    
    // Validate status
    Assert.assertEquals(response.getStatusCode(), 200, "Status should be 200");
    
    // Validate response data
    Assert.assertNotNull(loginResponse.getToken(), "Token should not be null");
    Assert.assertEquals(loginResponse.getUsername(), "testuser", "Username mismatch");
    Assert.assertNotNull(loginResponse.getEmail(), "Email should not be null");
    Assert.assertNotNull(loginResponse.getRoles(), "Roles should not be empty");
}
```

---

## 📊 Logging & Reports

### Console Logging

Logs are printed to the console with the following format:

```
15:53:19.020 [main] INFO  com.api.filters.LoggingFilter - Request Method: POST
15:53:19.035 [main] INFO  com.api.filters.LoggingFilter - Base URI : http://64.227.160.186:8080
15:53:19.045 [main] INFO  com.api.filters.LoggingFilter - Request URI: /api/auth/login
15:53:19.055 [main] INFO  com.api.filters.LoggingFilter - Response Status Code: 200
```

### File Logging

All logs are also written to `logs/test.log` for persistent record-keeping.

### Test Reports

After test execution, TestNG generates comprehensive reports:

1. **HTML Report**: `test-output/index.html`
   - Test summary
   - Pass/Fail statistics
   - Detailed test results
   - Stack traces for failures

2. **Email Report**: `test-output/emailable-report.html`
   - Formatted for email distribution
   - Summary of all test results

3. **XML Report**: `test-output/testng-results.xml`
   - Machine-readable format
   - Can be integrated with CI/CD pipelines

---

## ✅ Best Practices

### 1. **Use Service Classes**

❌ Don't write API calls directly in tests:
```java
@Test
public void test() {
    Response response = given().baseUri("http://...").post("/login");
}
```

✅ Use service classes instead:
```java
@Test
public void test() {
    AuthService authService = new AuthService();
    Response response = authService.login(loginRequest);
}
```

### 2. **Use Request/Response Models**

❌ Avoid using raw JSON strings:
```java
String body = "{\"username\":\"user\",\"password\":\"pass\"}";
```

✅ Use POJO classes:
```java
LoginRequest request = new LoginRequest("user", "pass");
```

### 3. **Generate Test Data with JavaFaker**

❌ Hardcoded test data:
```java
User user = new User();
user.setUsername("testuser123");
user.setEmail("test@example.com");
```

✅ Use JavaFaker for dynamic test data:
```java
Faker faker = new Faker();
User user = new User();
user.setUsername(faker.name().username());
user.setFirstName(faker.name().firstName());
user.setLastName(faker.name().lastName());
user.setEmail(faker.internet().safeEmailAddress());
user.setPassword(faker.internet().password(5, 10));
user.setPhone(faker.phoneNumber().cellPhone());
```

### 4. **Meaningful Test Names & Descriptions**

```java
@Test(description = "Verify successful login with valid credentials")
public void loginWithValidCredentials() { ... }
```

### 5. **Comprehensive Assertions**

```java
// Good: Multiple validations
Assert.assertEquals(response.getStatusCode(), 200);
Assert.assertNotNull(loginResponse.getToken());
Assert.assertEquals(loginResponse.getUsername(), "expectedUser");
```

### 6. **Error Handling**

```java
try {
    Response response = authService.login(loginRequest);
    if (response.getStatusCode() != 200) {
        System.out.println("Error: " + response.getBody().asString());
    }
} catch (Exception e) {
    Assert.fail("Test failed with exception: " + e.getMessage());
}
```

### 7. **Use Parameterized Tests with Data Providers**

For testing multiple scenarios with different data:

```java
@Test(dataProvider = "loginCredentials")
public void testLoginWithMultipleCredentials(String username, String password) {
    LoginRequest request = new LoginRequest(username, password);
    // ... test logic
}

@DataProvider
public Object[][] loginCredentials() {
    return new Object[][] {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"}
    };
}
```

### 8. **Leverage Lombok for POJO Generation**

❌ Manual getters and setters:
```java
public class User {
    private String username;
    private String email;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

✅ Using Lombok annotations:
```java
@Data
@Getter
@Setter
public class User {
    private String username;
    private String email;
    private String password;
}
```

### 9. **Use Excel Utilities for Test Data**

Leverage `ExcelUtility.java` to read test data from `TestData.xlsx`:

```java
@BeforeClass
public void loadTestData() {
    ExcelUtility excelUtil = new ExcelUtility();
    Object[][] testData = excelUtil.readExcelData("TestData.xlsx", "LoginSheet");
    // Use testData in tests
}
```

### 10. **Enable Parallel Test Execution**

Configure `suite.xml` for faster test runs:

```xml
<suite name="REST ASSURED API Test suite" parallel="tests" thread-count="5">
  <!-- tests run in parallel -->
</suite>
```

---

## 🔧 Troubleshooting

### Issue: Tests Fail with "Connection Refused"

**Solution:**
- Verify the API server is running at `http://64.227.160.186:8080`
- Check your network connectivity
- Update the BASE_URL in `BaseService.java` if the server address changed

```java
private static final String BASE_URL = "http://your-server:port";
```

### Issue: "403 Forbidden" Error

**Cause:** Invalid or missing authentication token

**Solution:**
- Verify credentials in test data
- Check if token is being set correctly
- Ensure token is not expired

```java
AuthService authService = new AuthService();
Response loginResponse = authService.login(loginRequest);
LoginResponse loginResp = loginResponse.as(LoginResponse.class);
authService.setAuthToken(loginResp.getToken());
```

### Issue: Jackson Deserialization Error

**Cause:** Response POJO class doesn't match API response structure

**Solution:**
- Verify field names match the API response
- Add `@JsonProperty` annotation if names differ
- Ensure getters/setters are present

```java
public class LoginResponse {
    @JsonProperty("access_token")
    private String token;
    
    public String getToken() {
        return token;
    }
}
```

### Issue: Logs Not Being Generated

**Solution:**
- Verify `log4j2.xml` exists in `src/test/resources/`
- Check log file path: `logs/test.log`
- Ensure `logs/` directory exists or is created automatically
- Verify Log4j2 dependencies are in pom.xml

### Issue: Tests Timeout

**Solution:**
- Increase timeout in test configuration
- Use `@Test(timeOut = 10000)` for 10-second timeout
- Check server response times
- Verify network connectivity

```java
@Test(description = "Long-running test", timeOut = 10000)
public void slowTest() {
    // ...
}
```

---

## 🤝 Contributing

To contribute to this project:

1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/new-feature`
3. **Commit** your changes: `git commit -am 'Add new feature'`
4. **Push** to the branch: `git push origin feature/new-feature`
5. **Submit** a Pull Request

### Code Style Guidelines

- Follow Java naming conventions (camelCase for variables/methods, PascalCase for classes)
- Add meaningful comments for complex logic
- Keep methods focused and single-responsibility
- Use meaningful variable names
- Add test descriptions for clarity

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 📞 Support & Contact

For issues, questions, or feature requests:

- **Create an Issue** on GitHub
- **Check Documentation** in this README
- **Review Test Examples** for implementation patterns

---

## 🎯 Roadmap

Future enhancements planned for this framework:

- [ ] Integration with CI/CD pipelines (Jenkins, GitHub Actions)
- [ ] Docker containerization
- [ ] Database validation support
- [ ] API performance/load testing
- [ ] Extended reporting with graphs/charts
- [ ] Test data management from external files
- [ ] Allure report integration
- [ ] Retry mechanism for flaky tests

---

**Last Updated:** June 2026  
**Framework Version:** 0.0.1-SNAPSHOT

---

## 🔗 Quick Links

- [REST Assured Documentation](https://rest-assured.io/)
- [TestNG Documentation](https://testng.org/)
- [Jackson Documentation](https://github.com/FasterXML/jackson)
- [Log4j2 Documentation](https://logging.apache.org/log4j/2.x/)
- [Maven Documentation](https://maven.apache.org/)

---

**Happy Testing! 🚀**
