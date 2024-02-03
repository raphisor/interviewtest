package com.strenger.interviewtest;

import com.strenger.interviewtest.page.texteditor.TextEditorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class TextEditorTest extends BaseSeleniumTest {

  @Autowired
  private TextEditorPage textEditorPage;

  @Test
  public void testTextEditor() {
    textEditorPage.gotoPage();
    textEditorPage.typeBoldText("Automation ");
    textEditorPage.typeItalicText("Test ");
    textEditorPage.typeText("Example");
  }
}
