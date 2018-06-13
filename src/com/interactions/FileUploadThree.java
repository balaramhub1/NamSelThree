package com.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadThree {
  
	WebDriver d1;
	
	//upload file interaction with Sikuli tool
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
  }
  
  @Test
  public void f() {
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
