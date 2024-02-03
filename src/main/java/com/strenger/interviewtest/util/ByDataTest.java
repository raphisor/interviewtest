package com.strenger.interviewtest.util;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByDataTest extends By {

  private final String dataTestValue;

  public ByDataTest(String dataTestValue) {
    this.dataTestValue = dataTestValue;
  }

  @Override
  public List<WebElement> findElements(SearchContext context) {
    return context.findElements(By.cssSelector(String.format("[data-test*='%s']", dataTestValue)));
  }
}