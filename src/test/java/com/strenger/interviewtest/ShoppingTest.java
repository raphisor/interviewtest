package com.strenger.interviewtest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.strenger.interviewtest.page.sauce.CartPage;
import com.strenger.interviewtest.page.sauce.InventoryPage;
import com.strenger.interviewtest.page.sauce.LoginPage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;


public class ShoppingTest extends BaseSeleniumTest {

  @Autowired
  private LoginPage loginPage;
  @Autowired
  private CartPage cartPage;
  @Autowired
  private InventoryPage inventoryPage;

  @Test
  public void testOrderFlow() {
    loginPage.gotoPage();
    loginPage.login("standard_user", "secret_sauce");
    List<String> itemsToBuy = List.of("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt");
    inventoryPage.addProductsToCart(itemsToBuy);
    assertEquals(itemsToBuy.size(), inventoryPage.getShoppingCartBadgeCount(),
        "Shopping cart badge count is not as expected");
    inventoryPage.gotoShoppingCart();
    cartPage.checkout();
    cartPage.fillOutForm("Ozzy", "Osbourne", "9999");
    cartPage.finish();
    assertEquals("Thank you for your order!", cartPage.getCompleteMessage(),
        "Complete message is not as expected");
  }

  @Test
  public void testLogin() {
    inventoryPage.gotoPage();
    assertTrue(loginPage.isDisplayed(), "Login page should be displayed");
    assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");

    loginPage.login("", "");
    assertTrue(loginPage.isErrorMessageDisplayed());
    assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
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
