package com.strenger.interviewtest;

import static org.testng.Assert.assertEquals;

import com.strenger.interviewtest.page.texteditor.TextEditorPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class TextEditorTest extends BaseSeleniumTest {

  @Autowired
  private TextEditorPage textEditorPage;

  @Test
  @Description("Testing Rich Text Editor with bold and italic text")
  @Severity(SeverityLevel.NORMAL)
  public void testTextEditor() {
    textEditorPage.gotoPage();
    textEditorPage.typeBoldText("Automation ");
    textEditorPage.typeItalicText("Test ");
    textEditorPage.typeText("Example");
    String expectedText = "Automation Test Example";
    String actualText = textEditorPage.getTextFromEditor();
    assertEquals(actualText, expectedText,
        "The text in the editor does not match the expected text");
  }
}
