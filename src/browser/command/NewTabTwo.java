package browser.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTabTwo {
	
	// Not working.....to be changed
	
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
	  WebElement link1=d1.findElement(By.linkText("Gmail"));
	  WebElement link2=d1.findElement(By.linkText("Advertising"));
	  WebElement link3=d1.findElement(By.linkText("Business"));
	  
	  Actions act=new Actions(d1);
	  Action newTab =act.moveToElement(link1).sendKeys(link1, Keys.CONTROL).click(link1).keyUp(Keys.CONTROL).build();
	  newTab.perform();
	  
	  	  
  }
  

  @AfterTest
  public void afterTest() {
	  d1.close();
	  d1.quit();
  }

}
