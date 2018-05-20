package WebDriverCommands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.StartBrowser;

public class ActionsDriver {

	public WebDriver driver;

	public ActionsDriver()
	{
		driver = StartBrowser.driver;
	}
	/**
	 * Used for navigate to application
	 * @param url --url of the application
	 */
	public void navigateToApplication(String url)
	{
		driver.get(url);
	}
	/**
	 * used to type in text box
	 * @param locator --Get it from Object Repository
	 * @param data -- What text you want to enter
	 * @throws Exception 
	 */
	public void type(By locator, String data, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(data);
			StartBrowser.childTest.pass("Successfully typed in "+eleName + "with Data : "+data);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to type in  "+eleName + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
			throw e;
		}
	}

	/**
	 * used to perform click on radio, chk,link and buttons
	 * @param locator --get it from object repository 
	 * @throws Exception
	 * @throws IOException
	 */
	public void click(By locator, String eleName) throws IOException, Exception
	{
		try {
		driver.findElement(locator).click();
		StartBrowser.childTest.pass("Successfully Clicked Element "+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to click element "+eleName + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
			throw e;
		}
		
		
	}
	/**
	* to perform mousehover on an element
	* @param locator
	* @throws Exception
	* @throws IOException
	*/
	public void mouseHover(By locator, String eleName) throws IOException, Exception
	{
	try {
	WebElement mo=driver.findElement(locator);
	Actions a = new Actions(driver);
	a.moveToElement(mo).perform();
	StartBrowser.childTest.pass("Successfully MouseHover on Element "+eleName);
	} catch (Exception e) {
	StartBrowser.childTest.fail("Unable to MouseHover on Element "+eleName + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
	throw e;
	}
	}
	
	
	public void waituntilText(By locator, String text) throws IOException, Exception
	{
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	        StartBrowser.childTest.pass("Successfully waitd for text" +text);
	    } catch (Exception e) {
	        StartBrowser.childTest.fail("Text is not visible: "+text + StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
	        throw e;
	    }
	    
	}
	public String screenshot(WebDriver driver) throws Exception
	{
		String src_path="/SShot/";
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(src_path+uuid+".jpeg"));
		}
		catch(Exception e)
		{
			System.out.println("Unable tp capture screenshot");
		}
		return src_path+uuid+".jpeg";
	}
}