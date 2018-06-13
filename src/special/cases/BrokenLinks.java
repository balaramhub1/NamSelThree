package special.cases;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {
 
	WebDriver d1;
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
	  d1.get("https://book2.spicejet.com/");
	  d1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void f() throws MalformedURLException {
	  List<WebElement> totalLinks=d1.findElements(By.tagName("a"));
	  String url1=totalLinks.get(0).getAttribute("href");
	  verifyLink(url1);
  }
  
  public void verifyLink(String ulink) throws MalformedURLException{
	  try 
      {
         URL url = new URL(ulink);
         
         HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
         
         httpURLConnect.setConnectTimeout(3000);
         
         httpURLConnect.connect();
         
         if(httpURLConnect.getResponseCode()==200)
         {
             System.out.println(ulink+" - "+httpURLConnect.getResponseMessage());
          }
        if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
         {
             System.out.println(ulink+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
          }
      } catch (Exception e) {
         
      }
	  
  }

  @AfterTest
  public void afterTest() {
	  d1.close();
	  d1.quit();
  }

}
