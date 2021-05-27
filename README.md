Maven

1. Updating versions of all dependencies
   mvn versions:use-latest-versions

//result
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< org.example:SouceDemo >------------------------
[INFO] Building SouceDemo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions-maven-plugin:2.8.1:use-latest-versions (default-cli) @ SouceDemo ---
[INFO] Major version changes allowed
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0-beta-3
[INFO] Updated org.testng:testng:jar:7.1.0 to version 7.4.0
[INFO] Updated io.github.bonigarcia:webdrivermanager:jar:4.4.1 to version 4.4.3
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.159 s
[INFO] Finished at: 2021-05-26T23:30:14+03:00
[INFO] ------------------------------------------------------------------------

2. Running tests
   mvn clean install

//result
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 164.465 sec
OpenJDK 64-Bit Server VM warning: ignoring option MaxPermSize=256m; support was removed in 8.0
Results :
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ SouceDemo ---
[INFO] Building jar: C:\Users\Kom\IdeaProjects\SouceDemo\target\SouceDemo-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ SouceDemo ---
[INFO] Installing C:\Users\Kom\IdeaProjects\SouceDemo\target\SouceDemo-1.0-SNAPSHOT.jar to C:\Users\Kom\.m2\repository\org\example\SouceDemo\1.0-SNAPSHOT\SouceDemo-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\Kom\IdeaProjects\SouceDemo\pom.xml to C:\Users\Kom\.m2\repository\org\example\SouceDemo\1.0-SNAPSHOT\SouceDemo-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  03:33 min
[INFO] Finished at: 2021-05-27T09:40:08+03:00
[INFO] ------------------------------------------------------------------------

3.1 Running tests
    mvn -Dtest=CheckoutTest#paymentCheckoutOverviewTest+paymentCheckoutCompleteTest test

//result
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 32.654 s - in tests.CheckoutTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  50.480 s
[INFO] Finished at: 2021-05-27T11:21:54+03:00
[INFO] ------------------------------------------------------------------------

3.2 Running tests
    mvn clean test -DsuiteXmlFile=src/test/resources/soucedemo.xml

//result
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 90.575 sec
Results :
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:48 min
[INFO] Finished at: 2021-05-26T23:48:57+03:00
[INFO] ------------------------------------------------------------------------

4. Passing parameters from the Maven command line inside the test
   mvn -Dtest=LoginTest#enterEmptyUsernameAndPasswordTest -Dusername=standart -Dpassword=secret test

//result
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.789 s - in tests.LoginTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  25.660 s
[INFO] Finished at: 2021-05-27T11:50:53+03:00
[INFO] ------------------------------------------------------------------------
