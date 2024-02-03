package com.strenger.interviewtest.page.sauce;

import com.strenger.interviewtest.annotation.Page;
import com.strenger.interviewtest.page.BasePage;
import com.strenger.interviewtest.util.ByDataTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Page
public class InventoryPage extends BasePage {

  private static final String URL = "https://www.saucedemo.com/inventory.html";
  private final By productListBy = By.className("inventory_item");
  private final By addToCartButtonBy = new ByDataTest("add-to-cart");
  private final By inventoryItemNameBy = By.className("inventory_item_name");
  private final By shoppingCartBadgeBy = By.className("shopping_cart_badge");
  private final By shoppingCartLinkBy = By.className("shopping_cart_link");
  private final By footerBy = By.className("footer_copy");

  public void gotoPage() {
    webDriver.get(URL);
  }


  public List<WebElement> getProducts() {
    return webDriver.findElements(productListBy);
  }

  public WebElement getProduct(String productName) {
    return getProducts().stream()
        .filter(product -> product.findElement(inventoryItemNameBy).getText().equals(productName))
        .findFirst().orElse(null);
  }

  public void addProductsToCart(List<String> productNames) {
    getProducts().stream().filter(
            product -> productNames.contains(product.findElement(inventoryItemNameBy).getText()))
        .forEach(product -> product.findElement(addToCartButtonBy).click());
  }

  public int getShoppingCartBadgeCount() {
    return Integer.parseInt(webDriver.findElement(shoppingCartBadgeBy).getText());
  }

  public String getFooterText() {
    return webDriver.findElement(footerBy).getText();
  }

  public boolean isFooterDisplayed() {
    return webDriver.findElement(footerBy).isDisplayed();
  }

  public void gotoShoppingCart() {
    webDriver.findElement(shoppingCartLinkBy).click();
  }
}