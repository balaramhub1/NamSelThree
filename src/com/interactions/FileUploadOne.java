package com.interactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadOne {
	
	// upload file in monsterindia.com website using Robot class
  WebDriver d1;
  
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
	  d1.get("http://www.monsterindia.com/");
	  d1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  d1.manage().window().maximize();
	  
	  //Specified the file location with extension.
	  StringSelection fileLoc=new StringSelection("D:\\TestData\\TestFileOne.doc");
	  
	  //copy the file path to clipboard.
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileLoc, null);
	  
	  
  }
  
  @Test
  public void f() throws AWTException, InterruptedException {
	  d1.findElement(By.xpath("//*[@id='jobuser_wrap']/div[2]")).click();
	  d1.findElement(By.id("wordresume")).click();
	  
	  Robot r1=new Robot();
	  Thread.sleep(2000);
	  
	  // Paste the file path, by pressing CTRL + V
	  r1.keyPress(KeyEvent.VK_CONTROL);
	  r1.keyPress(KeyEvent.VK_V);
	  
	  
	  // Release the key CTRL +V
	  r1.keyRelease(KeyEvent.VK_CONTROL);
	  r1.keyRelease(KeyEvent.VK_V);
	  
	  Thread.sleep(2000);
	  
	  // press Enter to open/submit the file.
	  r1.keyPress(KeyEvent.VK_ENTER);
	  r1.keyRelease(KeyEvent.VK_ENTER);
	  
  }

  @AfterTest
  public void afterTest() {
	  d1.close();
	  d1.quit();
  }

}
