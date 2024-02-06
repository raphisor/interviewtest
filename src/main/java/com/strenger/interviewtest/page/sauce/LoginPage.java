package com.strenger.interviewtest.page.sauce;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import com.strenger.interviewtest.util.ByDataTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


@Page
public class LoginPage extends BasePage {

  private static final String URL = "https://www.saucedemo.com";
  private final By usernameInput = By.id("user-name");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("login-button");
  private final By errorMessage = new ByDataTest("error");

  @Step("Open the login page")
  public void gotoPage() {
    webDriver.get(URL);
  }

  @Step("Check if the login page is displayed")
  public boolean isDisplayed() {
    return webDriver.findElement(loginButton).isDisplayed();
  }

  @Step("Check if the error message is displayed")
  public boolean isErrorMessageDisplayed() {
    return webDriver.findElement(errorMessage).isDisplayed();
  }

  @Step("Get the error message")
  public String getErrorMessage() {
    return webDriver.findElement(errorMessage).getText();
  }

  @Step("Login with username {username} and password {password}")
  public void login(String username, String password) {
    webDriver.findElement(usernameInput).sendKeys(username);
    webDriver.findElement(passwordInput).sendKeys(password);
    webDriver.findElement(loginButton).click();
  }

  @Step("Login with no credentials")
  public void loginWithNoCredentials() {
    webDriver.findElement(loginButton).click();
  }
}