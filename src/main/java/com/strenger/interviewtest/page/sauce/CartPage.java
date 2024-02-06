package com.strenger.interviewtest.page.sauce;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import com.strenger.interviewtest.util.ByDataTest;
import org.openqa.selenium.By;


@Page
public class CartPage extends BasePage {

  private static final String URL = "https://www.saucedemo.com/cart.html";
  private final By checkoutButtonBy = new ByDataTest("checkout");
  private final By fieldFirstNameBy = new ByDataTest("firstName");
  private final By fieldLastNameBy = new ByDataTest("lastName");
  private final By fieldZipCodeBy = new ByDataTest("postalCode");
  private final By continueButtonBy = new ByDataTest("continue");
  private final By finishButtonBy = By.className("cart_button");
  private final By completeMessageBy = By.className("complete-header");

  public void checkout() {
    webDriver.findElement(checkoutButtonBy).click();
  }

  public boolean isDisplayed() {
    return webDriver.findElement(checkoutButtonBy).isDisplayed();
  }

  public void fillOutForm(String firstName, String lastName, String zipCode) {
    webDriver.findElement(fieldFirstNameBy).sendKeys(firstName);
    webDriver.findElement(fieldLastNameBy).sendKeys(lastName);
    webDriver.findElement(fieldZipCodeBy).sendKeys(zipCode);
    webDriver.findElement(continueButtonBy).click();
  }

  public void finish() {
    webDriver.findElement(finishButtonBy).click();
  }

  public String getCompleteMessage() {
    return webDriver.findElement(completeMessageBy).getText();
  }

  @Override
  public void gotoPage() {
    webDriver.get(URL);
  }
}
