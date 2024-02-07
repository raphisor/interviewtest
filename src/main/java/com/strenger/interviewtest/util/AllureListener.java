package com.strenger.interviewtest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureListener extends TestListenerAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(AllureListener.class);

  @Override
  public void onTestStart(ITestResult result) {
    LOGGER.info("Test started: " + result.getName());
    super.onTestStart(result);
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    LOGGER.info("Test successful: " + result.getName());
    super.onTestSuccess(result);
  }

  @Override
  public void onTestFailure(ITestResult result) {
    LOGGER.info("Test failed: " + result.getName());
    super.onTestFailure(result);
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    LOGGER.info("Test skipped: " + result.getName());
    super.onTestSkipped(result);
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    LOGGER.info("Test failed but within success percentage: " + result.getName());
    super.onTestFailedButWithinSuccessPercentage(result);
  }
}