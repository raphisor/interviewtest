package com.strenger.interviewtest.config;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
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

  public static final String URL = "http://localhost:4444";

  @Bean
  @Primary
  @ConditionalOnProperty(name = "browser", havingValue = "chrome")
  public WebDriver chromeDriver() throws MalformedURLException {
    ChromeOptions options = new ChromeOptions();
    return new RemoteWebDriver(new URL(URL), options);
  }

}
