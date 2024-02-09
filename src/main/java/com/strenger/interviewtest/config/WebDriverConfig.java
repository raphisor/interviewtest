package com.strenger.interviewtest.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("!grid")
@Lazy
@Configuration
public class WebDriverConfig {

  @Bean
  public WebDriver webDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    return new ChromeDriver(options);
  }

}