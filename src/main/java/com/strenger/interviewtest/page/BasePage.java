package com.strenger.interviewtest.page;

import io.qameta.allure.Step;
import jakarta.annotation.PostConstruct;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BasePage {

  @Autowired
  protected WebDriver webDriver;

  @PostConstruct
  private void init() {
    PageFactory.initElements(this.webDriver, this);
  }

  public abstract void gotoPage();

  @Step("Get page title")
  public String getTitle() {
    return webDriver.getTitle();
  }

  @Step("Scroll to bottom of page")
  public void scrollToBottom() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }

  @Step("Hover over element")
  public void hoverOverElement(By locator) {
    Actions actions = new Actions(webDriver);
    actions.moveToElement(webDriver.findElement(locator)).perform();
  }

  @Step("Click and switch to new tab")
  public void clickAndSwitchToNewTab(By locator) {
    Set<String> originalTabs = webDriver.getWindowHandles();

    webDriver.findElement(locator).click();
    webDriver.getWindowHandles()
        .stream()
        .filter(windowHandle -> !originalTabs.contains(windowHandle))
        .findFirst()
        .ifPresent(handle -> webDriver.switchTo().window(handle));
  }

  @Step("Close current tab")
  public void closeTab() {
    webDriver.close();
    webDriver.getWindowHandles().stream().findFirst()
        .ifPresent(handle -> webDriver.switchTo().window(handle));
  }
}
