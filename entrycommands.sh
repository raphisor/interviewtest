#!/bin/bash
mvn clean test -Dspring.profiles.active=grid
cp -r /app/qa/allure-results /
