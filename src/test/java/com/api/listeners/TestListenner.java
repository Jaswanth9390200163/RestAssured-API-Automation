package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenner implements ITestListener {
	public static final Logger logger = LogManager.getLogger(TestListenner.class);

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test suite started !!!: " + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test case started!!! : " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test case passed!!! : " + result.getMethod().getMethodName());
		logger.info("Description!!! : " + result.getMethod().getDescription());
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("Test case failed!!! : " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test case skipped!!! : " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test suite finished!!! : " + context.getName());
	}

}
