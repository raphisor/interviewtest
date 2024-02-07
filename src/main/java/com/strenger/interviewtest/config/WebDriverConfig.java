package com.strenger.interviewtest.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Lazy
@Configuration
public class WebDriverConfig {

  @Bean
  @Primary
  public WebDriver webDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    System.setProperty("webdriver.chrome.args", "--disable-logging");
    System.setProperty("webdriver.chrome.silentOutput", "true");
    options.addArguments("disable-infobars");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-gpu");
    options.addArguments("window-size=1024,768");
    return new ChromeDriver(options);
  }

}