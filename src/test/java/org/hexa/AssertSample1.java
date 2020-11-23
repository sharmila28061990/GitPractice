package org.hexa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssertSample1 extends BaseClass {

	@Test
	public void method() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhan\\eclipse-workspace\\TestNG\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Assert.assertEquals("Checking URL", "https://www.facebook.com/", driver.getCurrentUrl());
		WebElement txtUser = driver.findElement(By.id("email"));
		txtUser.sendKeys("hii");
		Assert.assertEquals("Username", "hii", txtUser.getAttribute("value"));
		driver.findElement(By.id("u_0_b")).isEnabled();
				
	}
	
}
 