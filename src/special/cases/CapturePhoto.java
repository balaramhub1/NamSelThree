package special.cases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapturePhoto {
  
	WebDriver d1;
  @BeforeTest
  public void beforeTest() {
	  d1=new FirefoxDriver();
	  d1.get("https://www.linkedin.com/");
	  d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  
  @Test
  public void f() {
	  // function to take Screenshot of the current screen.
	  File src=((TakesScreenshot)d1).getScreenshotAs(OutputType.FILE);
	  try{
		  FileUtils.copyFile(src, new File("D:\\Programming\\workspaceJAVA\\NamSelThree\\src\\snap.png"));
	  }
	  catch(IOException e){
		  System.out.println("Error in taking snapshot");
	  }
	  
  }

  @AfterTest
  public void afterTest() {
	  d1.close();
	  d1.quit();
  }

}
