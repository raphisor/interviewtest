package com.strenger.interviewtest;


import static org.testng.Assert.assertEquals;

import com.strenger.interviewtest.page.guru.GuruHomePage;
import com.strenger.interviewtest.page.guru.LiveSeleniumProjectPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class GuruTest extends BaseSeleniumTest {

  @Autowired
  private GuruHomePage guruHomePage;

  @Autowired
  private LiveSeleniumProjectPage liveSeleniumProjectPage;

  @Test
  @Description("iFrame and tab handling")
  @Severity(SeverityLevel.NORMAL)
  public void testTabHandling() {
    guruHomePage.gotoPage();
    guruHomePage.scrollToBottom();
    guruHomePage.clickImageInIframe();
    assertEquals(liveSeleniumProjectPage.getTitle(),
        "Selenium Live Project: FREE Real Time Project for Practice",
        "Page title does not match expected value.");
    liveSeleniumProjectPage.closeTab();
    guruHomePage.openSeleniumTutorialPage();
  }
}
