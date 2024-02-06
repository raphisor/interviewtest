package com.strenger.interviewtest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.strenger.interviewtest.annotation.JsonData;
import com.strenger.interviewtest.dataProvider.JsonDataProvider;
import com.strenger.interviewtest.page.sauce.CartPage;
import com.strenger.interviewtest.page.sauce.InventoryPage;
import com.strenger.interviewtest.page.sauce.LoginPage;
import com.strenger.interviewtest.pojo.testdata.UITestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;


public class ShoppingTest extends BaseSeleniumTest {

  @Autowired
  private LoginPage loginPage;
  @Autowired
  private CartPage cartPage;
  @Autowired
  private InventoryPage inventoryPage;

  @Test(dataProvider = "getDataFromJson", dataProviderClass = JsonDataProvider.class)
  @JsonData(model = UITestData.class, filepath = "src/test/resources/testdata/orderFlow.json")
  public void testOrderFlow(UITestData testData) {
    loginPage.gotoPage();
    loginPage.login(testData.getUsername(), testData.getPassword());
    inventoryPage.addProductsToCart(testData.getItemsToBuy());
    int expectedBadgeCount = testData.getItemsToBuy().size();
    assertEquals(expectedBadgeCount, inventoryPage.getShoppingCartBadgeCount(),
        "Shopping cart badge count is not as expected");
    inventoryPage.gotoShoppingCart();
    cartPage.checkout();
    cartPage.fillOutForm(testData.getFirstName(), testData.getLastName(), testData.getZipCode());
    cartPage.finish();
    assertEquals("Thank you for your order!", cartPage.getCompleteMessage(),
        "Complete message is not as expected");
  }

  @Test
  public void testNoCredentialLogin() {
    inventoryPage.gotoPage();
    assertTrue(loginPage.isDisplayed(), "Login page should be displayed");
    assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");

    loginPage.loginWithNoCredentials();
    assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
    assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage(),
        "Error message test doesn't match");
  }

  @Test
  public void testFooter() {
    loginPage.gotoPage();
    loginPage.login("standard_user", "secret_sauce");
    inventoryPage.scrollToBottom();
    assertTrue(inventoryPage.isFooterDisplayed());
    assertTrue(inventoryPage.getFooterText().contains("2024"));
    assertTrue(inventoryPage.getFooterText().contains("Terms of Service"));
  }

}
