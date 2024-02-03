package com.strenger.interviewtest.page;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BasePage {

  @Autowired
  protected WebDriver webDriver;

  @PostConstruct
  private void init() {
    PageFactory.initElements(this.webDriver, this);
  }

  public void scrollToBottom() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }
}
