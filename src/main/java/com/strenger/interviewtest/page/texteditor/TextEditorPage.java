package com.strenger.interviewtest.page.texteditor;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Page
public class TextEditorPage extends BasePage {

  private static final String URL = "https://onlinehtmleditor.dev/";
  private final By boldButtonBy = By.className("cke_button__bold");
  private final By italicButtonBy = By.className("cke_button__italic");
  private final By underlineButtonBy = By.className("cke_button__underline");
  private final By textInputFieldBy = By.cssSelector("body > p");

  public void gotoPage() {
    webDriver.get(URL);
  }


  public void clickUnderlineButton() {
    webDriver.findElement(underlineButtonBy).click();
  }

  public void clickBoldButton() {
    webDriver.findElement(boldButtonBy).click();
  }

  public void typeBoldText(String text) {
    clickBoldButton();
    typeText(text);
    clickBoldButton();
  }

  public void typeItalicText(String text) {
    clickItalicButton();
    typeText(text);
    clickItalicButton();
  }

  public void clickItalicButton() {
    webDriver.findElement(italicButtonBy).click();
  }

  public void typeText(String text) {
    webDriver.switchTo().frame(0);
    WebElement inputField = webDriver.findElement(textInputFieldBy);
    inputField.sendKeys(text);
    webDriver.switchTo().defaultContent();
  }

  public String getTextFromEditor() {
    webDriver.switchTo().frame(0);
    WebElement inputField = webDriver.findElement(textInputFieldBy);
    String text = inputField.getText();
    webDriver.switchTo().defaultContent();
    return text;
  }
}
