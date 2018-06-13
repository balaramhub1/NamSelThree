package com.interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTwo {
  
	WebDriver d1;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Programming\\SeleniumJars\\geckodriver.exe");
	  d1=new FirefoxDriver();
	  d1.get("http://www.ksrtc.in/oprs-web/");
	  d1.manage().window().maximize();
	  d1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }
  
  @Test
  public void f() throws InterruptedException {
	  d1.findElement(By.id("searchBtn")).click();
	  String alText=d1.switchTo().alert().getText();
	  System.out.println("Text on the Alert popu is :"+alText);
	  
	  Thread.sleep(3000);
	  d1.switchTo().alert().accept();
	  
  }

  @AfterTest
  public void afterTest() {
	  d1.close();
	  d1.quit();
  }

}
