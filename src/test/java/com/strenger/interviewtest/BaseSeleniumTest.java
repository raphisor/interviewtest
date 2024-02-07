package com.strenger.interviewtest;

import com.strenger.interviewtest.util.AllureListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@SpringBootTest(classes = InterviewtestApplication.class)
@Listeners(AllureListener.class)
public class BaseSeleniumTest extends AbstractTestNGSpringContextTests {

  @Autowired
  public WebDriver webDriver;

  @BeforeTest
  public void setup() {
  }

  private static final Logger LOGGER = LogManager.getLogger(BaseSeleniumTest.class);

  @AfterTest
  public void tearDown() {
    LOGGER.info("Teardown WebDriver");
    webDriver.quit();
  }

}
