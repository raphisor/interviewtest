package com.strenger.interviewtest;

import com.strenger.interviewtest.util.ScreenShotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;

@SpringBootTest
public class BaseSeleniumTest extends AbstractTestNGSpringContextTests {

  @Lazy
  @Autowired
  protected ScreenShotUtil screenShotUtil;
  private static final Logger LOGGER = LogManager.getLogger(BaseSeleniumTest.class);

  @AfterTest
  public void tearDown() {
    LOGGER.info("Test completed");
    applicationContext.getBean(WebDriver.class).quit();
  }
}
