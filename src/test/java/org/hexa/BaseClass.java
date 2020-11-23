package org.hexa;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Madhan\\eclipse-workspace\\MavenProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	public static void enterUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static void printUrl() {
		driver.getCurrentUrl();
	}
	public static void printTitleOfUrl() {
		driver.getTitle();
	}
	public static void enterText(WebElement element, String txt) {
		element.sendKeys(txt);
	}
	public static void click(WebElement element) {
		element.click();
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static void navigateToUrl(String url) {
		driver.navigate().to(url);
	}
	public static void refresh() {
		driver.navigate().refresh();
	}//10
	public static void forward() {
		driver.navigate().forward();
	}
	public static void backward() {
		driver.navigate().back();
	}
	public static void printText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
	public static void getAttribute(WebElement element) {
		String text1 = element.getAttribute("value");
		System.out.println(text1);
	}
	static Actions ac ;
	public static void moveToElement(WebElement element) {
		ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public static void doubleClick(WebElement element) {
		ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}
	public static void dragAndDrop(WebElement element1,WebElement element2 ) {
		ac = new Actions(driver);
		ac.dragAndDrop(element1, element2).perform();
	}
	public static void contextClick(WebElement element) {
		ac = new Actions(driver);
		ac.contextClick(element).perform();
	}
	public static void enterCaps(WebElement element) {
		ac.keyUp(element, Keys.SHIFT).sendKeys(element,"hi Java").keyDown(element, Keys.SHIFT).perform();
	}
	static Robot r ;
	public static void select() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}//20
	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void enter() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void tab() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	static Alert a;
	public static void acceptAlert() {
		a=driver.switchTo().alert();
		a.accept();
	}
	public static void dismissAlert() {
		a=driver.switchTo().alert();
		a.dismiss();
	}
	static Select s;
	public static void pickByIndex(WebElement element, int i) {
		s = new Select(element);
		s.selectByIndex(i);
	}
	public static void selectByValue(WebElement element, String s1) {
		s = new Select(element);
		s.selectByValue(s1);
	}
	public static void selectByVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}
	public static void printUsingTextSingle(WebElement element) {
		s = new Select(element);
		List<WebElement> li = s.getOptions();
		WebElement element2 = li.get(1);
		String text = element2.getText();
		System.out.println(text);
	}//30
	public static void printUsingTextAll(WebElement element) {
		s = new Select(element);
		List<WebElement> li = s.getOptions();
		for (WebElement e : li) {
			String text = e.getText();
		System.out.println(text);
		}
	}
	public static void printUsingvalueSingle(WebElement element) {
		s = new Select(element);
		List<WebElement> li = s.getOptions();
		WebElement element2 = li.get(1);
		String text = element2.getAttribute("value");
		System.out.println(text);
	}
	public static void printUsingValueAll(WebElement element) {
		s = new Select(element);
		List<WebElement> li = s.getOptions();
		for (WebElement e : li) {
			String text = e.getAttribute("value");
		System.out.println(text);
		}
	}	
	public static void selectAllByIndex(WebElement element) {
			s = new Select(element);
			List<WebElement> li = s.getOptions();
			for (int i = 0; i < li.size(); i++) {
				s.selectByIndex(i);
			}	
	}
	public static void selectAllByValue(WebElement element) {
			s = new Select(element);
			List<WebElement> li = s.getOptions();
			for (int i = 0; i < li.size(); i++) {
				String name = li.get(i).getAttribute("value");
				s.selectByValue(name);
			}
	}	
	public static void selectAllByVisibleText(WebElement element) {
				s = new Select(element);
				List<WebElement> li = s.getOptions();
				for (int i = 0; i < li.size(); i++) {
					String name = li.get(i).getText();
					s.selectByVisibleText(name);
			}	
	}
	public static void printAllTextSelected(WebElement element) {
			s = new Select(element);
			List<WebElement> li = s.getOptions();
			for (int i = 0; i < li.size(); i++) {
				String name = li.get(i).getText();
				System.out.println(name);
		}	
	}
	public static void getFirstSelectedOption(WebElement element) {
			s = new Select(element);
			WebElement option = s.getFirstSelectedOption();
			System.out.println(option.getText());
	}
	public static void deSelectByIndex(WebElement element, int i) {
			s = new Select(element);
			s.deselectByIndex(i);
	}
	public static void deSelectAll(WebElement element) {
			s = new Select(element);
			s.deselectAll();
	}//40
	public static void isMultiple(WebElement element) {
			s = new Select(element);
			boolean b = s.isMultiple();
			System.out.println(b);
	}
	public static void deSelectByValue(WebElement element, String s1) {
			s = new Select(element);
			s.deselectByValue(s1);
	}
	public static void deSelectByVisibleText(WebElement element, String name) {
			s = new Select(element);
			s.deselectByVisibleText(name);
	}
	public static void takeScreenShot() throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File ("D:\\");
		FileHandler.copy(source,dest);
	}
	static JavascriptExecutor js;
	public static void sendKeysUsinJS(WebElement element, String name) {
		js.executeScript("argument[0].setAttribute('value','name')", element);
	}
	public static void clickUsinJS(WebElement element) {
		js.executeScript("argument[0].click()", element);
	}
	public static void getAttributeUsinJS(WebElement element) {
		String name = (String) js.executeScript("return argument[0].getAttribute('value')", element);
		System.out.println(name);
	}
	public static void scrollUp(WebElement element) {
		js.executeScript("argument[0].scrollIntoView(true)", element);
	}	
	public static void scrollDown(WebElement element) {
		js.executeScript("argument[0].scrollIntoView(flase)", element);
	}
	public static void frameSize() {
		List<WebElement> list = driver.findElements(By.tagName("frameset"));
		int size = list.size();
		System.out.println(size);
	}//50
	public static void switchToFrameByIndex(int i) {
		driver.switchTo().frame(i);
	}
	public static void switchToFrameByName(String name) {
		driver.switchTo().frame(name);
	}
	public static void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void switchToNormalWindow() {
		driver.switchTo().defaultContent();
	}
	public static void printParentWindow() {
		String prtId = driver.getWindowHandle();
		System.out.println(prtId);
	}
	public static void switchParentWindow() {
		String prtId = driver.getWindowHandle();
		driver.switchTo().window(prtId);
	}//50
	public static void printAllWindows() {
	Set<String> li = driver.getWindowHandles();
		System.out.println(li);
	}
	public static void switchTochildWindow1() {
		String prtId = driver.getWindowHandle();
		Set<String> li = driver.getWindowHandles();
		for (String s : li) {
			if (!prtId.equals(s)) {
				driver.switchTo().window(s);
			}
		}
	}
	public static void switchTochildWindowMany() {
		Set<String> li = driver.getWindowHandles();
		ArrayList<Object> list = new ArrayList<Object>();
		list.addAll(li);
		driver.switchTo().window( (String) list.get(2));
	}
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}//60
//	public static void explicitWait() {
//		Wait w = new FluentWait(driver).withTimeout(50, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//	
//	}
	public static String excelRead(int rowNum, int colNum) throws IOException {
	File f = new File("C:\\Users\\Madhan\\eclipse-workspace\\MavenProject\\Excel\\adactinhoteldetails.xlsx");
	FileInputStream stream = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(stream);
	Sheet sheet = w.getSheet("Sheet1");
	
		Row r = sheet.getRow(rowNum);{
		
			Cell c = r.getCell(colNum);
			String value = "";
			int cellType = c.getCellType();
			if (cellType==1) {
				
			value = c.getStringCellValue();
			
		}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				value = sdf.format(d);
				
			}
			else {
				double d = c.getNumericCellValue();
				long l= (long) d;
				value = String.valueOf(l);
				
			}return value;
		}
	}
				
	
}
