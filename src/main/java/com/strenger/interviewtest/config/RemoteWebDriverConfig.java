package com.strenger.interviewtest.config;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("grid")
@Lazy
@Configuration
public class RemoteWebDriverConfig {

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnProperty(name = "browser", havingValue = "chrome")
  @Primary
  public WebDriver remoteChromeDriver() throws MalformedURLException {
    ChromeOptions chromeOptions = new ChromeOptions();
    return new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
  }
}