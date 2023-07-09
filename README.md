# **Assignment- Guardian News Articles Authenticity Test.**

**Technical Stack:**

- Automation Tool: Selenium (Java Library)
- Test automation framework: Cucumber
- Reporting: Cucumber Default reporting.
- Build tool: Maven
- Java as coding Language
- Docker for Containerization

## Selenium-Cucumber-Automation-Framework.
  **This framework contains:**
- Runner class > Defines which feature/step Definitions/Reports Plugins to include in test.
- Step Definitions class > Defines implementation of test scenarios defined in feature file.
- Feature file > Defines the Test scenarios in Gherkin language.
- TestUtils class > Define methods like String Similarity Score(Check if news matches with other sources), Validates authenticity of Guardian news, FileInputStream.
- TestBase >  Defines WebDriver methods (setup, tearDown) using ChromeOptions & RemoteWebDriver.
- config.properties file > Defines url's and endPoints.
- 3 Scenarios: “GuardianNewsTest.feature”
  - Verify the authenticity of The Guardian's first news article by cross-referencing with other sources to validate its accuracy.
  - Verify the authenticity of The Guardian's second news article by cross-referencing with other sources to validate its accuracy.
  - Invalidate the authenticity of The Guardians first news article by cross-referencing with other sources to invalidate its accuracy.

**Note:**


## **Steps to run at your system/container:**
**Prerequisite:** Maven, Java, Git installation.

- Run "git clone https://github.com/ssdev1510/GuardianNewsAssignment.git" to Clone the repository.
- Run "cd GuardianNewsAssignment" to Go inside directory.
- Run "mvn clean"
- Run "mvn test -DisHeadless=true" (Incase you want to run tests in non headless mode then mark it false)
- Check the test result report as mentioned in below section.

## **Steps to run at Docker Container:**
**Prerequisite:** Docker, Maven, Java, Git installation.
- Run "git clone https://github.com/ssdev1510/GuardianNewsAssignment.git" to Clone the repository.
- Run "cd GuardianNewsAssignment" to Go inside directory.
- Run "sudo docker build -t guardian_selenium_test_image ." to Build docker image from Dockerfile.
- Run "docker run --name guardian_test_image_name -d -p 4444:4444 --shm-size="2g" guardian_selenium_test_image" Runs docker container to start Standalone Chrome container.
- Run "mvn clean test -DisHeadless=true" Running maven commands to execute tests in headless mode.
- Run "docker rm guardian_test_image_name" to Remove docker container.
- Run "docker rmi guardian_test_image_name" to  Remove docker image.
- Check the test result report as mentioned in below section.

**Note:** Using Shell Scipt: Above mentioned steps can also be executed in one go.
- Run "git clone https://github.com/ssdev1510/GuardianNewsAssignment.git" to Clone the repository.
- Run "cd GuardianNewsAssignment" to Go inside directory.
- Run "sudo bash ./seleniumRemoteTest.sh" to execute shell script.
- Check the test result report as mentioned in below section.
