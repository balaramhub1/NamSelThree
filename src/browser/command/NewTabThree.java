package browser.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTabThree {
	
	WebDriver d1;
  
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
	  d1.get("https://google.co.in/");
	  d1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  d1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  d1.manage().window().maximize();
  }
  
  @Test
  public void f() {
	  
	  //Open tab 2 using CTRL + t keys.
	  d1.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

	  //Open URL In 2nd tab.
	  d1.get("http://yahoo.com/");

	  //Navigate to Yahoo Mail link
	  d1.findElement(By.linkText("Mail")).click();
	  
	  switchTab();
	  
	//Call switchToTab() method to switch to 1st tab
	  switchTab();
  }
  
  public void switchTab() {
	  //Switching between tabs using CTRL + tab keys.
	  d1.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	  //Switch to current selected tab's content.
	  d1.switchTo().defaultContent();  
	 } 

  @AfterTest
  public void afterTest() {
	  d1.close();
	  d1.quit();
  }

}
