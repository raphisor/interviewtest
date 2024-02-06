package com.strenger.interviewtest;


import static org.testng.Assert.assertEquals;

import com.strenger.interviewtest.page.guru.GuruHomePage;
import com.strenger.interviewtest.page.guru.LiveSeleniumProjectPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class GuruTest extends BaseSeleniumTest {

  @Autowired
  private GuruHomePage guruHomePage;

  @Autowired
  private LiveSeleniumProjectPage liveSeleniumProjectPage;

  @Test
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
