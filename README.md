# qa-ui-cuke
The qa framework supports web based user interface testing with BDD framework.
The framework uses Page objects design pattern.
For rich user friendly report output, framework is using extended reports.
It supports cross browser testing, included chrome and gecko drivers.
Picocontainer is used for dependency injection.
Also made use of third party library SharedDriver for faster execution of test scenarios.
It opens the browser once for each session and close it after executing all scenarios.

### Technology Stack
- Java 8
- Maven 3
- Cucumber JVM
- AssertJ
- Master thought extended report
- Picocontainer
- chromeDrivers
    mac - Chrome Browser: Version 71.0.3578.80
          ChromeDriver: 2.44
          Mozilla Browser: Version 63.0.3
          GeckoDrive: 0.22


### Prerequisites
- Java 1.8
- Maven
- Compatible browser versions

### Set Up
Download and Install
1. Java 8
2. Maven 3
3. Set java and maven in environment variables
4. Set up proxy or artifactory settings for maven if required, so that program could download dependencies when executed first time.

### Env vars required
- cuke_BASE_URL = Required. Pass the core web url ending with /, e.g. http://google.com.au/
- cucumber.opts = Optional. If not passed all the features with tag 'ui' will be executed. Check following sections for more details.

### Running the tests
The framework uses the Cucumber BDD framework and maven for build and execution
For execution, open command line and cd to the project folder. Execute one of following commands as per requirement
`mvn test` to run unit tests (currently just an example unit test)

`mvn verify -Dcuke_BASE_URL=http://google.com.au/` to run all the feature/scenario (tagged with `@api`)

`mvn verify -Dcucumber.opts="--tags @borrowing" -Dcuke_BASE_URL=http://google.com.au/ ` to run features/scenarios tagged `@borrowing`

Please check the Test features and tags under src/test/features

### Cross Browser Testing
By default application uses chrome browser. To change the driver please pass parameter
`mvn verify -Dcuke_browser=firefox`

### Debug in IntelliJ
`mvn verify -DforkMode=never`

### Check Report
1. Go to project directory and open target directory
2. Go to extended reports folder target/extended-reports/cucumber-html-reports
3. Open any html file in browser from there. Index page is overview-features.html

### Feature files
Find here src/test/features

### Authors

* **Monika Suniara** - [MonikaSuniara](https://www.linkedin.com/in/monikasuniara/)

### License

Copyright (c) Monika Suniara - All Rights Reserved
This qa-ui-cuke is a private project. Unauthorized copying of this project, via any medium is strictly prohibited.
