package org.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	public static WebDriver driver;
@Parameters({"browser"})
@Test
private void method1(String name) {
	if(name.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhan\\eclipse-workspace\\TestNG\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if (name.equalsIgnoreCase("FF")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Madhan\\eclipse-workspace\\TestNG\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	else {
		System.out.println("No Browsers");
	}
}
@Test
private void method2() {
	driver.get("https://www.facebook.com/");
	WebElement txtUser = driver.findElement(By.id("email"));
	txtUser.sendKeys("Hii");
	WebElement password = driver.findElement(By.id("pass"));
	password.sendKeys("java");
}
}

