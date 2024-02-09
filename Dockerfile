FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app/qa
RUN chmod -R 777 /app/qa

#Copy source code and pom file.
COPY /src /app/qa/src
COPY pom.xml /app/qa
COPY entrycommands.sh /app/qa
COPY test-suite.xml /app/qa

RUN chmod 111 /app/qa/entrycommands.sh

ENTRYPOINT /app/qa/entrycommands.sh