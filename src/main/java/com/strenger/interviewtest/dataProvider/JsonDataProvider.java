package com.strenger.interviewtest.dataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strenger.interviewtest.annotation.JsonData;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;


public class JsonDataProvider {

  @DataProvider(name = "getDataFromJson")
  public Object[][] getDataFromJson(ITestNGMethod testNGMethod) {
    Method method = testNGMethod.getConstructorOrMethod().getMethod();
    if (method.isAnnotationPresent(JsonData.class)) {
      JsonData jsonData = method.getAnnotation(JsonData.class);
      Class<?> model = jsonData.model();
      String filepath = jsonData.filepath();
      ObjectMapper objectMapper = new ObjectMapper();
      try {
        Object testData = objectMapper.readValue(Files.newInputStream(Paths.get(filepath)), model);
        return new Object[][]{{testData}};
      } catch (IOException e) {
        throw new RuntimeException("Failed to read test data from JSON file", e);
      }
    } else {
      throw new IllegalArgumentException(
          "Method " + method.getName() + " does not have the @JsonData annotation");
    }
  }
}