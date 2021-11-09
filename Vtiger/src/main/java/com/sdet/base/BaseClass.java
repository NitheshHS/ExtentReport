package com.sdet.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver staticDriver;//null
	
	public EventFiringWebDriver eventDriver;
	
	@BeforeSuite(groups = {"smoketest","regression"})
	public void configBS() {
		System.out.println("Connect to db");
		
	}

	@Parameters(value = {"browser"})//chrome,firefox
	@BeforeClass(groups = {"smoketest","regression"})
	public void configBC(@Optional("chrome") String browser) throws Throwable{
		//String browser=FileUtil.getPropertyKeyValue("browser");
		System.out.println("Launching browser : "+browser);

		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else {
			System.out.println("Invalid browser entry: "+browser);
		}
		//WebDriverListner regDriver=new WebDriverListner();
		// eventDriver=new EventFiringWebDriver(driver);
		//eventDriver.register(regDriver);
		staticDriver =driver;//assignig driver ref

	}

	@BeforeMethod(groups = {"smoketest","regression"})
	public void setUP(ITestResult result) {
		System.out.println("Logging In to Vtiger");
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager", Keys.ENTER);
	}

	@AfterMethod(groups = {"smoketest","regression"})
	public void tearDown() {
		System.out.println("Logging out from Vtiger");
		WebElement admin=driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
		Actions act=new Actions(driver);
		WebElement signout=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		act.moveToElement(admin).click(signout).build().perform();
	}

	@AfterClass(groups = {"smoketest","regression"})
	public void configAC() {
		System.out.println("closing browser");
		driver.close();
	}


	@AfterSuite(groups = {"smoketest","regression"})
	public void configAS() {
		System.out.println("close DB connection");
	}


}
