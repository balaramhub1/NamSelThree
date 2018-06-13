package browser.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserNav {
	WebDriver d1;
  
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
	  d1.get("http://www.calculator.net/");
	  d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  d1.manage().window().maximize();
	  d1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }
  
  @Test(priority=1)
  public void CaseOne() {
	  d1.findElement(By.xpath("//*[@id='hl1']/li[2]/a")).click();
	  
  }
  
  @Test(priority=2)
  public void CaseTwo(){
	  d1.findElement(By.xpath("//*[@id='hl2']/li[2]/a")).click();
	  d1.navigate().back();
	  d1.navigate().forward();
  }
  
  @AfterMethod
  public void homeScreen(){
	  d1.navigate().back();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  d1.close();
	  d1.quit();
  }

}
