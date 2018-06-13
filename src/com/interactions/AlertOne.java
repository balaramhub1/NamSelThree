package com.interactions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertOne {
	
	WebDriver d1;
	WebDriverWait w1;
	
	//script to handle the popup at https://hdfcbank.com/
  
  @BeforeTest
  public void beforeTest() {
		d1=new FirefoxDriver();
		w1=new WebDriverWait(d1,20);
		d1.get("https://hdfcbank.com/");
		d1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d1.manage().window().maximize();
  }
  
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(10000);
	  Set<String> handles1=d1.getWindowHandles();
	  Iterator<String> hi=handles1.iterator();
	  System.out.println("Handles are : "+handles1);
	  /*String bankHomeHandle=hi.next();
	  String popupHome=hi.next();
	  d1.switchTo().window(popupHome);*/
	  d1.findElement(By.id("closeImage")).click();
  }
  
  public boolean alertCheck(){
	  try{
		  d1.switchTo().alert();
		  return true;
	  }
	  catch(Exception e){
		  return false;
	  }
	  
  }

  @AfterTest
  public void afterTest() {
	  d1.close();
	  d1.quit();
  }

}
