# Interview Test

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17
- Maven, download it from [here](https://maven.apache.org/download.cgi).
- Allure, download it from [here](https://docs.qameta.io/allure/).
- Chromedriver, download it from [here](https://chromedriver.chromium.org/downloads).
- Place the Chromedriver in a location that is specified in the application.properties file.

## Running the Tests

To run the tests, follow these steps:

1. Open a terminal in the project root directory.
2. Run the following command to build the project and run the tests:

```bash
mvn clean test
```

## Running the Tests with Allure Report

Run the following command in the project root directory to generate the Allure report:

```bash
allure serve allure-results
```

# Docker

You can run the suite with docker by running the following commands in the root directory:
The dockerized solution currently missing the reporting feature

```bash
docker build -t interviewtest:1.0 .
```

```bash
docker compose up
```
