#!/bin/bash
#Shell Script to run Selenium Standalone Chrome docker container and execute the Selenium/Cucumber Automation Tests.
#Prerequist - Docker, Java, Maven, Git setup on local machine.

#Git Clone
#echo ">>>> Cloning the git repository from github <<<<"
#git clone https://github.com/ssdev1510/GuardianNewsAssignment.git

#Getting into the directory
#echo ">>>> Getting into the directory <<<<"
#cd GuardianNewsAssignment

#Building image from Dockerfile
echo ">>>> Creating image from docker file with name guardian__selenium_test_image <<<<"
docker build -t guardian_selenium_test_image .

#Running below command to start Selenium Standalone Chrome container 
echo ">>>> Running docker container to start Standalone Chrome container<<<<"
docker run --name guardian_test_image_name -d -p 4444:4444 --shm-size="2g" guardian_selenium_test_image 

#Running below the maven commands to execute selenium tests in headless mode
echo ">>>> Running maven commands to execute tests in headless mode <<<<"
mvn clean test -DisRemote=true

#Stopping docker container
echo ">>>> Stopping Docker Container <<<<"
docker stop guardian_test_image_name

#Removing docker container
echo ">>>> Removing Docker Container <<<<"
docker rm guardian_test_image_name

#Removing docker image
echo ">>>> Removing Docker Image <<<<"
docker rmi guardian_selenium_test_image

#Check Test result report.
echo ">>>> Please check the Test Result Report under /target/html_reports/index.html <<<<"
