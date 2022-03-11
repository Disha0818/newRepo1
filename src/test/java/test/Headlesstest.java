package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Headlesstest {
  @Test
  public void HeadlessTesting() {
	  HtmlUnitDriver driver = new HtmlUnitDriver();
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
