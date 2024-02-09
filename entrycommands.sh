#!/bin/bash
mvn clean test -Dspring.profiles.active=grid
allure serve allure-results