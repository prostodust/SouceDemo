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
