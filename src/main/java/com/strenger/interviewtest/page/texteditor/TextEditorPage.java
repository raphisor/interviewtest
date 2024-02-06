package com.strenger.interviewtest.page.texteditor;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Page
public class TextEditorPage extends BasePage {

  private static final String URL = "https://onlinehtmleditor.dev/";
  private final By boldButtonBy = By.className("cke_button__bold");
  private final By italicButtonBy = By.className("cke_button__italic");
  private final By underlineButtonBy = By.className("cke_button__underline");
  private final By textInputFieldBy = By.cssSelector("body > p");

  @Step("Open Text Editor page")
  public void gotoPage() {
    webDriver.get(URL);
  }


  @Step("Click underline button")
  public void clickUnderlineButton() {
    webDriver.findElement(underlineButtonBy).click();
  }

  @Step("Click bold button")
  public void clickBoldButton() {
    webDriver.findElement(boldButtonBy).click();
  }

  @Step("Type bold text")
  public void typeBoldText(String text) {
    clickBoldButton();
    typeText(text);
    clickBoldButton();
  }

  @Step("Type italic text")
  public void typeItalicText(String text) {
    clickItalicButton();
    typeText(text);
    clickItalicButton();
  }

  @Step("Click italic button")
  public void clickItalicButton() {
    webDriver.findElement(italicButtonBy).click();
  }

  @Step("Type text into the editor")
  public void typeText(String text) {
    webDriver.switchTo().frame(0);
    WebElement inputField = webDriver.findElement(textInputFieldBy);
    inputField.sendKeys(text);
    webDriver.switchTo().defaultContent();
  }

  @Step("Get text from the editor")
  public String getTextFromEditor() {
    webDriver.switchTo().frame(0);
    WebElement inputField = webDriver.findElement(textInputFieldBy);
    String text = inputField.getText();
    webDriver.switchTo().defaultContent();
    return text;
  }
}
