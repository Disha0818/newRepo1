package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Googletest {
  @Test
  public void f() {
	  
//	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Disha\\Documents\\Chromedriver\\chromedriver.exe");
	 WebDriverManager.chromedriver().setup();
	 
	  WebDriver driver = new ChromeDriver();
	  
//	  WebDriverManager.edgedriver().setup();
		 
//	  WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		WebElement firstn = driver.findElement(By.name("q"));
		firstn.sendKeys("Java tutorail");
		firstn.submit();
  }
}
