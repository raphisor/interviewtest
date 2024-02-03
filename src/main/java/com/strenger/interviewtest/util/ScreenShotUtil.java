package com.strenger.interviewtest.util;

import java.io.File;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Lazy
@Component
public class ScreenShotUtil {

  @Autowired
  private TakesScreenshot driver;
  @Value("${screenshot.path}")
  private Path path;

  public void takeScreenShot(final String imgName) {
    try {
      File sourceFile = this.driver.getScreenshotAs(OutputType.FILE);
      FileCopyUtils.copy(sourceFile, this.path.resolve(imgName).toFile());
      System.out.println("Saving screenshot to " + path);
    } catch (Exception e) {
      System.out.println("Something went wrong with screenshot capture" + e);
    }
  }
}