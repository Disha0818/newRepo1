package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Remotedriver {
	WebDriver driver;
  @Test
  public void f()  throws MalformedURLException {
	  
	  ChromeOptions options = new  ChromeOptions();
	  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
	  String strHub =  "http://192.168.1.8:4444  ";
	  driver = new RemoteWebDriver( new URL(strHub), options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		WebElement searchbox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));
		searchbox.sendKeys("Java Tutorial");
		searchbox.submit();
		System.out.println("Page title: "+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
  }
}
