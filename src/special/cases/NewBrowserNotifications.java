package special.cases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewBrowserNotifications {
  
	WebDriver d1;
		
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","D:\\Programming\\SeleniumJars\\chromedriver_2_27_win32\\chromedriver.exe");
	  Map<String,Object> prefs=new HashMap<String,Object>();
	  prefs.put("profile.default_content_setting_values.notifications", 2);
	  ChromeOptions co=new ChromeOptions();
	  co.setExperimentalOption("prefs", prefs);
	  
	  WebDriver d1=new ChromeDriver(co);
	  
	  d1.get("https://google.co.in/");
	  
	  
  }
  
  @Test
  public void f() {
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
	  d1.close();
	  d1.quit();
  }

}
