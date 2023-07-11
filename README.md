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
- Feature file > Defines the Test scenarios in Gherkin language.
- TestRunner class > Defines which feature/step Definitions/Reports Plugins to include in test.
- Step Definitions class > Defines implementation of test scenarios defined in feature file.
- TestBase >  Defines WebDriver methods (setup, tearDown) using ChromeOptions & RemoteWebDriver.
- TestUtils class > Define methods like String Similarity Score(Check if news matches with other sources), Validates authenticity of Guardian news, FileInputStream.
- PageObject > Defines page locators and actions.
- config.properties file > Defines url's and endPoints.
- 3 Scenarios: “GuardianNewsTest.feature”
  - Verify the authenticity of The Guardian's first news article by cross-referencing with other sources.
  - Verify the authenticity of The Guardian's second news article by cross-referencing with other sources.
  - Invalidate the authenticity of The Guardians first news article by cross-referencing with other sources(Negative Scenario).

**Note:**
- There is one negative test scenario so test result is intent to be failed and which can we viewed in test result report below.

## **Steps to run at your system:**
**Prerequisite:** Maven, Java, Git installation.

- Run "git clone https://github.com/ssdev1510/GuardianNewsAssignment.git" to Clone the repository.
- Run "cd GuardianNewsAssignment" to Go inside directory.
- Run "mvn clean"
- Run "mvn test -DisRemote=false" (False: To run in UI mode, True: To run in headless mode in a container)
- Check the test result report as mentioned in below section.

## **Steps to run at Docker Container:**
**Prerequisite:** Docker, Maven, Java, Git installation.
- Run "git clone https://github.com/ssdev1510/GuardianNewsAssignment.git" to Clone the repository.
- Run "cd GuardianNewsAssignment" to Go inside directory.
- Run "sudo docker build -t guardian_selenium_test_image ." to Build docker image from Dockerfile.
- Run "docker run --name guardian_test_image_name -d -p 4444:4444 --shm-size="2g" guardian_selenium_test_image" Starts Standalone Chrome container.
- Run "mvn clean test -DisRemote=true" Running maven commands to execute tests in headless mode inside docker container.
- Run "docker rm guardian_test_image_name" to Remove docker container.
- Run "docker rmi guardian_selenium_test_image" to  Remove docker image.
- Check the test result report as mentioned in below section.

**Note:** Using Shell Scipt: Above mentioned steps can also be executed in one go.
- Run "git clone https://github.com/ssdev1510/GuardianNewsAssignment.git" to Clone the repository.
- Run "cd GuardianNewsAssignment" to Go inside directory.
- Run "sudo bash ./seleniumRemoteTest.sh" to execute shell script.
- Check the test result report as mentioned in below section.

## **Reports:** 
  **This will generate two visual reports:**
- HTML Reporting (Project folder - "target\html_reports"), file - "index.html"
- Cloud Reporting - Link could be find in terminal post execution > for example: (View your Cucumber Report at: https://reports.cucumber.io/reports/**  ) - Cloud reporting is available only for 24 hours.

**Logs:** Logs can be found under (folder - "\logs" )folder, file - ".log".

## **Directory Structure:**
<kbd>![Alt text](/readmeImages/directory.png?raw=true)</kbd>

## **Test output from Terminal:**
<kbd>![Alt text](/readmeImages/buildSuccess.png?raw=true)</kbd>

## **Reports**:
<kbd>![Alt text](/readmeImages/testReport.png?raw=true)</kbd>


