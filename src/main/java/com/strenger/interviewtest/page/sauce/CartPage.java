package com.strenger.interviewtest.page.sauce;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import com.strenger.interviewtest.util.ByDataTest;
import io.qameta.allure.Step;
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


  @Step("Check if the page is displayed")
  public boolean isDisplayed() {
    return webDriver.findElement(checkoutButtonBy).isDisplayed();
  }

  @Step("Fill out the form with data: {firstName}, {lastName}, {zipCode}")
  public void fillOutForm(String firstName, String lastName, String zipCode) {
    webDriver.findElement(fieldFirstNameBy).sendKeys(firstName);
    webDriver.findElement(fieldLastNameBy).sendKeys(lastName);
    webDriver.findElement(fieldZipCodeBy).sendKeys(zipCode);
    webDriver.findElement(continueButtonBy).click();
  }

  @Step("Click on the checkout button")
  public void checkout() {
    webDriver.findElement(checkoutButtonBy).click();
  }

  @Step("Click on the finish button")
  public void finish() {
    webDriver.findElement(finishButtonBy).click();
  }

  @Step("Get checkout complete message")
  public String getCompleteMessage() {
    return webDriver.findElement(completeMessageBy).getText();
  }

  @Override
  @Step("Open the cart page")
  public void gotoPage() {
    webDriver.get(URL);
  }
}
