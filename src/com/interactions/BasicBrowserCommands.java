package com.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/* Script is to demonstrate the basic Browser commands used in Selenium.
 * 1. driver.get(string url);
 * 2. driver.getTitle();
 * 3. driver.getCurrentUrl();
 * 4. driver.getPageSource();
 * 5. driver.close();
 * 6. driver.quit();
 * 7. driver.navigate().refresh();
 * 
 * */


public class BasicBrowserCommands {

	public static void main(String[] args) {

		//create instance of firefox browser
		WebDriver d1=new FirefoxDriver();
		
		//navigate to yahoo.co.in
		d1.get("http://yahoo.co.in");
		
		//get the Title of the page and store it in a string "tit"
		String tit=d1.getTitle();
		
		//print the stored title
		System.out.println("Title of the Page is : "+tit);
		
		//navigate to google.com
		d1.get("http://google.com");
		
		//get the current URL
		String curUrl=d1.getCurrentUrl();
		
		System.out.println("Current URL is : "+curUrl);
		
		String pSource=d1.getPageSource();
		
		System.out.println("Page source is below::");
		
		System.out.println(pSource);
	
		//navigate to previous page
		d1.navigate().back();
		
		//close the current browser window
		d1.close();
		
		//terminate the WebDriver,close all the windows and the browser.
		d1.quit();

	}

}
