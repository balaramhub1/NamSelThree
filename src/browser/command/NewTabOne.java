package browser.command;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class NewTabOne {

	WebDriver d1;

	@BeforeTest
	public void beforeTest() {
		d1 = new FirefoxDriver();
		d1.get("https://google.co.in");
		d1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d1.manage().window().maximize();
	}

	@Test
	public void f() {

		d1.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(d1.getWindowHandles());
		d1.switchTo().window(tabs.get(0));
		d1.get("http://yahoo.com");
	}

	@AfterTest
	public void afterTest() {
		d1.close();
		d1.quit();
	}

}
