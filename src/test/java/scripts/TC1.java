package scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import config.StartBrowser;
import reuse.commonFunctions;

public class TC1 extends StartBrowser {
  @Test
  public void testLogin_Logout() throws IOException, Exception {
	  commonFunctions sign = new commonFunctions ();
	  sign.login();
	  sign.logout();
	  
  }
}
