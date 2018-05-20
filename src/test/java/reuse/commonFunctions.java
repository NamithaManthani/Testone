package reuse;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.MyAccountPage;
import WebDriverCommands.ActionsDriver;
import config.StartBrowser;
import utils.Xls_Reader;

public class commonFunctions {

	public WebDriver driver;
	public ActionsDriver aDriver;
	
	public commonFunctions()
	{
		driver = StartBrowser.driver;
		aDriver = new ActionsDriver();
		
	}
	public void login() throws IOException, Exception
	{
	 StartBrowser.childTest= StartBrowser.parentTest.createNode("Sign in to OPENEDU Application");
	 aDriver.navigateToApplication("https://www.open.edu.au/");
	 aDriver.click(HomePage.lnkSignIn,"Sign IN");
	 aDriver.type(LoginPage.txtEmail, "mcat18@open.edu.au", "Username");
	 aDriver.type(LoginPage.txtPassword, "test@1234", "Password");
	 aDriver.click(LoginPage.btnSignIn, "SignIn Button");
	 aDriver.waituntilText(MyAccountPage.msgHeader, "Student Hub");
	}
	public void login(String userName, String password) throws IOException, Exception
	{
	StartBrowser.childTest= StartBrowser.parentTest.createNode("Login to OpenEDU Application");
	aDriver.navigateToApplication("https://www.open.edu.au/");
	aDriver.click(HomePage.lnkSignIn,"Sign In");
	aDriver.type(LoginPage.txtEmail, userName, "Email");
	aDriver.type(LoginPage.txtPassword,password, "Password");
	aDriver.click(LoginPage.btnSignIn, "SignIn button");
	aDriver.waituntilText(MyAccountPage.msgHeader, "Student Hub");
	}
	public void logout() throws IOException, Exception
	{
		StartBrowser.childTest= StartBrowser.parentTest.createNode("Sign out of OPENEDU Application");
		aDriver.mouseHover(MyAccountPage.lnkStuDentHub,"Studnet Hub");
		aDriver.click(MyAccountPage.lnkSignOut, "SignOut");
	}
}
