package com.sdet.base;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverListner implements WebDriverEventListener{

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Switching to Alert: "+driver.toString());
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Switching to Alert: "+driver.toString());
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Dismiss Alert: "+driver.toString());
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Accept Alert: "+driver.toString());
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Naviagating url: "+url);
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigating url: "+url);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before navigate Back : "+ driver.toString());
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After navigate Back : "+ driver.toString());
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before navigate forward : "+ driver.toString());
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("after navigate Forward : "+ driver.toString());
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before navigate Refresh : "+ driver.toString());
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Before navigate Refresh : "+ driver.toString());
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before Finding the element : "+by +" element: "+element.getTagName());
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("After Finding the element : "+by +" element: "+element.getTagName());
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking on Element: "+element);
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After clicking on Element: "+element);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before Entering the Value: "+keysToSend.toString());
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("After Entering the Value: "+keysToSend.toString());
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

}
