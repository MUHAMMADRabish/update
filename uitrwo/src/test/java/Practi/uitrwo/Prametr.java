package Practi.uitrwo;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Prametr {
	WebDriver driver=null;
  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys(n);
	  driver.findElement(By.id("pass")).sendKeys(s);
	  driver.findElement(By.xpath("//*[@aria-label='Log In']")).click();
	  Thread.sleep(6000);
	  driver.navigate().back();
	  Thread.sleep(6000);
	  driver.findElement(By.id("email")).clear();
	  Thread.sleep(6000);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "slem@gmail.com", "airmed" },
      new Object[] { "mizamur@gmail.com", "uitrdj" },
      new Object[] { "khalida@gmail.com", "uitrdj" },
    };
  }
  @BeforeClass
  @Parameters({"browser","url"})
  public void beforeClass(String br, String rt) {
	  if(br.equalsIgnoreCase("chrome")) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver(); 
	  driver.get(rt);
	  }else if(br.equalsIgnoreCase("firefox")) {
		  System.out.println("This is firefox");
	  }
  }

  @AfterClass
  public void afterClass() {
  }

}
