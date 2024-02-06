package com.strenger.interviewtest.page.guru;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import org.openqa.selenium.By;

@Page
public class LiveSeleniumProjectPage extends BasePage {

  private static final String URL = "https://www.guru99.com/live-selenium-project.html";
  private final By headerTitleBy = By.cssSelector(
      "h1.entry-title:contains('Selenium Live Project')");

  @Override
  public void gotoPage() {
    webDriver.get(URL);
  }

  public boolean isDisplayed() {
    return webDriver.findElement(headerTitleBy).isDisplayed();
  }

}
