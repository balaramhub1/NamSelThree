package com.interactions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown {
  
	WebDriver d1;
	List<WebElement> passNo;
	Select dd1;
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
	  d1.get("http://newtours.demoaut.com/");
	  d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  d1.manage().window().maximize();
  }
  
  
  
  @Test(priority=1)
  public void Login() throws InterruptedException {
	  d1.findElement(By.name("userName")).sendKeys("ramOne");
	  d1.findElement(By.name("password")).sendKeys("asdfjkl;1");
	  d1.findElement(By.name("login")).click();
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority=2)
  public void setFlightDetails(){
	  d1.findElement(By.xpath("//input[@value='oneway']")).click();
	  dd1=new Select(d1.findElement(By.name("passCount")));
	  passNo=dd1.getOptions();
	  
	  System.out.println(passNo.get(2).getText());
	  dd1.selectByValue("2");
	  
	  dd1=new Select(d1.findElement(By.name("fromPort")));
	  dd1.selectByIndex(2);
	  
	  dd1=new Select(d1.findElement(By.name("fromMonth")));
	  dd1.selectByVisibleText("August");
	  	  
  }
  
  @Test(priority=3)
  public void setPreferences(){
	  d1.findElement(By.xpath("//input[@value='Business']")).click();
	  d1.findElement(By.name("findFlights")).click();
  }
  
  // //form[@name='findflight']/table/tbody/tr[2]/td[2]/b/font/input[2]
  
  @Test(priority=3)
  public void signOut(){
	  d1.findElement(By.linkText("SIGN-OFF")).click();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  d1.close();
	  d1.quit();
  }

}
