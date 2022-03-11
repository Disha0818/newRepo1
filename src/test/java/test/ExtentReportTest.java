package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import CommonUtils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReportTest {
	
	WebDriver driver;
	ExtentReports extentReport;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReport = new ExtentReports();
		spark = new ExtentSparkReporter("target/SparkReport.html");
		extentReport.attachReporter(spark);
	}

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
  @Test
  
  public void f() {
	  extentTest = extentReport.createTest("f");
	  
	  driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google hit");  //hard assert
		WebElement firstn = driver.findElement(By.name("q"));
		firstn.sendKeys("Selenium");
		firstn.submit();
  }
  
  @Test
  public void f3() {
	  extentTest = extentReport.createTest("f3");
		driver.get("https://www.google.com");
		WebElement firstn = driver.findElement(By.name("q"));
		firstn.sendKeys("Cucumber framework");
		firstn.submit();
		
}
  @AfterMethod
  public void endtest(ITestResult result) {
	  if(ITestResult.FAILURE == result.getStatus()) {
		  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		  String path = Utility.getScreenshotPath(driver);
		  extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  }
	  else if (ITestResult.SUCCESS == result.getStatus()) {
		  extentTest.log(Status.PASS, "Test got successsfully executed....");
	  }
	  driver.close();
  }
  
  @AfterTest
  public void finishExtent()
  {
	  extentReport.flush();
  }
}
