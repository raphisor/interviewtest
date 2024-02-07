FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app/qa
RUN chmod -R 777 /app/qa

# Install tools.
RUN apt update -y
RUN apt upgrade -y
RUN apt install -y wget unzip gnupg2
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get install -y tzdata

#Copy source code and pom file.
COPY /src /app/qa/src
COPY pom.xml /app/qa
COPY test-suite.xml /app/qa

# Install Chrome.
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
RUN apt-get update
RUN apt-get install -y chromium-bsu

# Install ChromeDriver.
RUN wget -N https://chromedriver.storage.googleapis.com/105.0.5195.19/chromedriver_linux64.zip -P ~/
RUN unzip ~/chromedriver_linux64.zip -d ~/
RUN rm ~/chromedriver_linux64.zip
RUN mv -f ~/chromedriver src/main/resources/drivers/
RUN chmod +x  src/main/resources/drivers/chromedriver

ENTRYPOINT mvn clean test