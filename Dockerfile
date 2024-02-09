FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app/qa
RUN chmod -R 777 /app/qa

# Install tools.
RUN apt update -y
RUN apt upgrade -y
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get install -y tzdata
RUN apt-get install -y allure

#Copy source code and pom file.
COPY /src /app/qa/src
COPY pom.xml /app/qa
COPY entrycommands.sh /app/qa
COPY test-suite.xml /app/qa

RUN chmod +x /app/qa/entrycommands.sh

ENTRYPOINT /app/qa/entrycommands.sh