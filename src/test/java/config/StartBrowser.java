package config;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class StartBrowser {
  public static WebDriver driver;
  String method;
  public ExtentHtmlReporter htmlReporter;
  public static ExtentReports extent;
  public static ExtentTest parentTest;
  public static ExtentTest childTest;
  
  @BeforeTest
  public void report ()
  {
	  htmlReporter= new ExtentHtmlReporter("Reports/MyHtmlReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
  }
  @BeforeMethod
  public void methodName(Method method)
  {
	  parentTest = extent.createTest(method.getName());
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
	  //launch browser
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  //implicit Wait
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
  }

  @AfterClass
  public void afterClass() {
	driver.quit();
	extent.flush();
  }

}
