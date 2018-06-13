package browser.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTabFour {
	
	
	// Not Working.
	WebDriver d1;
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Programming\\SeleniumJars\\chromedriver_2_27_win32\\chromedriver.exe");
	  d1=new ChromeDriver();
	  d1.get("https://google.co.in/");
	  d1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  d1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  d1.manage().window().maximize();
	  
  }
  
  
  @Test
  public void f() {
	  
	  /*d1.FindElement(By.CssSelector("body")).SendKeys(Keys.Control + "t");        
	  string newTabInstance = driver.WindowHandles[d1.WindowHandles.Count-1].ToString();
	  d1.SwitchTo().Window(newTabInstance);
	  d1.Navigate().GoToUrl(url);
	  */
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
