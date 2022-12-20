package com.GreenKart.Ver.testing;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Resources.AbstractComponents;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	//@Parameters({"browserName","appURL"})
	@BeforeTest(alwaysRun=true)
	public void invokeBrowser() {
		String Browser ="C";
		if(Browser.equalsIgnoreCase("C")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("F")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("E")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		new LandingPage(driver);
	}
	
	@AfterTest(alwaysRun=true)
	public void CloseBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
