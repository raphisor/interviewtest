package com.strenger.interviewtest.page.guru;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

@Page
public class SeleniumTutorialPage extends BasePage {

  private final By joinNowButtonBy = By.xpath("//button[text()='Join us']");

  @Override
  public void gotoPage() {
    webDriver.get("https://www.guru99.com/selenium-tutorial.html");
  }

  @Step("Check if Join Now button is displayed")
  public boolean isJoinNowButtonDisplayed() {
    return isElementDisplayed(joinNowButtonBy);
  }
}
