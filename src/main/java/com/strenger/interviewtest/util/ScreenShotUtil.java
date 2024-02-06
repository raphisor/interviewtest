package com.strenger.interviewtest.util;

import java.io.File;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Lazy
@Component
public class ScreenShotUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(ScreenShotUtil.class);

  @Autowired
  private TakesScreenshot driver;
  @Value("${screenshot.path}")
  private Path path;

  public void takeScreenShot(final String imgName) {
    try {
      LOGGER.info("Taking screenshot with name {}", imgName);
      File sourceFile = this.driver.getScreenshotAs(OutputType.FILE);
      FileCopyUtils.copy(sourceFile, this.path.resolve(imgName).toFile());
      LOGGER.info("Screenshot taken successfully");
    } catch (Exception e) {
      LOGGER.error("Error while taking screenshot", e);
    }
  }
}