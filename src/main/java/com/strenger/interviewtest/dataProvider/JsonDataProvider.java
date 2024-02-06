package com.strenger.interviewtest.dataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strenger.interviewtest.annotation.JsonData;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

public class JsonDataProvider {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonDataProvider.class);

  @DataProvider(name = "getDataFromJson")
  public Object[][] getDataFromJson(ITestNGMethod testNGMethod) {
    Method method = testNGMethod.getConstructorOrMethod().getMethod();
    if (method.isAnnotationPresent(JsonData.class)) {
      JsonData jsonData = method.getAnnotation(JsonData.class);
      Class<?> model = jsonData.model();
      String filepath = jsonData.filepath();
      ObjectMapper objectMapper = new ObjectMapper();
      try {
        LOGGER.info("Reading test data from JSON file {}", filepath);
        Object testData = objectMapper.readValue(Files.newInputStream(Paths.get(filepath)), model);
        LOGGER.info("Successfully read test data from JSON file {}", filepath);
        return new Object[][]{{testData}};
      } catch (IOException e) {
        LOGGER.error("Failed to read test data from JSON file {}", filepath, e);
        throw new RuntimeException("Failed to read test data from JSON file", e);
      }
    } else {
      throw new IllegalArgumentException(
          "Method " + method.getName() + " does not have the @JsonData annotation");
    }
  }
}