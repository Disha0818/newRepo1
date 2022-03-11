package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampletest {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
  @Test(priority=3)
  public void f2() {
	  
		driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google");  //hard assert
		WebElement firstn = driver.findElement(By.name("q"));
		firstn.sendKeys("Selenium");
		firstn.submit();
		Assert.assertEquals(driver.getTitle(), "Selenium - Google Search");
  }
  
  @Test(priority=1)
  public void f3() {
	  
		driver.get("https://www.google.com");
		SoftAssert softAssert = new SoftAssert();    //soft assert
		softAssert.assertEquals(driver.getTitle(), "Google");
		WebElement firstn = driver.findElement(By.name("q"));
		firstn.sendKeys("Cucumber framework");
		firstn.submit();
		softAssert.assertAll();
}
  
  @Test(priority=2)
  public void f34() {
	  
		driver.get("https://www.google.com");
		
		WebElement firstn = driver.findElement(By.name("q"));
		firstn.sendKeys("Maven");
		firstn.submit();
}
  
  @AfterMethod
  public void end() {
	  driver.close();
  }
  
  }
  
