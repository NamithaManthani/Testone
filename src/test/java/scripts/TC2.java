package scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.MyAccountPage;
import config.StartBrowser;
import reuse.commonFunctions;
import utils.Xls_Reader;

public class TC2 extends StartBrowser {
  @Test
  public void testLogin_LogoutWithParameter() throws IOException, Exception {
	  Xls_Reader reader = new Xls_Reader("TestData/SIGNDATA.xlsx");
	  String userName=reader.getCellData("Sheet1", "UserName", 2);
	  String password=reader.getCellData("Sheet1", "Password", 2);

	    commonFunctions sign= new commonFunctions();
	    
	    sign.login(userName, password);
	    //String actMsg=driver.findElement(MyAccountPage.msgHeader).getText();
	    //Assert.assertEquals(actMsg, "Student Hub");
	    sign.logout();
	  
  }
}
