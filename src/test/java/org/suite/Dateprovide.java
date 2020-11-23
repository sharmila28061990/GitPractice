package org.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dateprovide {
	
	@DataProvider(name ="value")
	public Object[][] getData(){
	return new Object[][]{{"Apple"},{"RealMe"},{"MIredme"},{"Samsung"}};
	}
	
	@Test(dataProvider="value")
	public void method(String s1) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhan\\eclipse-workspace\\TestNG\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement txtUser = driver.findElement(By.id("twotabsearchtextbox"));
		txtUser.sendKeys(s1, Keys.ENTER);
	}
}
