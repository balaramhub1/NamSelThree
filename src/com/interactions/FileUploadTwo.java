package com.interactions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTwo {
  
	WebDriver d1;
	
	//Handling upload file action with AutoIT
	
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
	  d1.get("http://www.monsterindia.com/");
	  d1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  d1.manage().window().maximize();
	  
  }
  
  @Test
  public void f() throws IOException {
	  d1.findElement(By.xpath("//*[@id='jobuser_wrap']/div[2]")).click();
	  d1.findElement(By.id("wordresume")).click();
	  
	  //Run AutoIT script to upload the file.
	  Runtime.getRuntime().exec("D:\\Programming\\AutoIT_Scripts\\fileUploadOne.exe");
	  
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  d1.close();
	  d1.quit();
  }

}
