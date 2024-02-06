package com.strenger.interviewtest.page.guru;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

@Page
public class GuruHomePage extends BasePage {

  private static final String URL = "http://demo.guru99.com/test/guru99home";

  private final By iframeBy = By.id("a077aa5e");
  private final By testingBy = By.className("item118");

  public void gotoPage() {
    webDriver.get(URL);
  }

  @Step("Click image in iframe")
  public void clickImageInIframe() {
    webDriver.switchTo().frame(webDriver.findElement(iframeBy));
    clickAndSwitchToNewTab(By.cssSelector("img"));
    webDriver.switchTo().defaultContent();
  }

  @Step("Open Selenium tutorial page")
  public void openSeleniumTutorialPage() {
    hoverOverElement(testingBy);
    webDriver.findElement(By.linkText("Selenium")).click();
  }


}