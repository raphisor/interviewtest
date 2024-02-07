package com.strenger.interviewtest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strenger.interviewtest.pojo.user.User;
import com.strenger.interviewtest.service.UserService;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import java.io.IOException;
import java.util.List;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class RestTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private UserService userService;

  private static final Logger LOGGER = LogManager.getLogger(RestTest.class);

  @Test
  @Description("Test GET /users")
  @Severity(SeverityLevel.NORMAL)
  public void testGetUsers() throws IOException {

    Response response = userService.getUsers();
    assertEquals(response.code(), 200, "Status code should match");

    List<User> users = objectMapper.readValue(response.body().string(),
        objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));

    assertTrue(users.get(0).getEmail().contains("@"),
        users.get(0) + "'s Email does not contain '@'");
    users.forEach(user -> LOGGER.info(user.getName() + " " + user.getEmail()));
  }
}
