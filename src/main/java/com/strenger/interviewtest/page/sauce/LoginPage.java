package com.strenger.interviewtest.page.sauce;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import com.strenger.interviewtest.util.ByDataTest;
import org.openqa.selenium.By;


@Page
public class LoginPage extends BasePage {

  private static final String URL = "https://www.saucedemo.com";
  private final By usernameInput = By.id("user-name");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("login-button");
  private final By errorMessage = new ByDataTest("error");


  public void gotoPage() {
    webDriver.get(URL);
  }

  public boolean isDisplayed() {
    return webDriver.findElement(loginButton).isDisplayed();
  }

  public boolean isErrorMessageDisplayed() {
    return webDriver.findElement(errorMessage).isDisplayed();
  }

  public String getErrorMessage() {
    return webDriver.findElement(errorMessage).getText();
  }


  public void login(String username, String password) {
    webDriver.findElement(usernameInput).sendKeys(username);
    webDriver.findElement(passwordInput).sendKeys(password);
    webDriver.findElement(loginButton).click();
  }
  
  public void loginWithNoCredentials() {
    webDriver.findElement(loginButton).click();
  }
}