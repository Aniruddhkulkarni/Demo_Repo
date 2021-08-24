package TestCases_New;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import BaseClass.base;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class upShopTestCase extends base{
	private static EnhancedAndroidDriver<MobileElement> driver;
	
	public void LoginMethod(String UserName, String Password, String SeverName , String TentCode) throws IOException, InterruptedException
		{
		public TestWatcher watcher = Factory.createWatcher();
			// TODO Auto-generated method stub
			service=startServer();
			driver=capabilities("upShopApp");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
		}
	
	 @After
	    public void TearDown(){
	        driver.label("Stopping App");
	        driver.quit();
	    }
	/*
	@Test
	public void test2()
	{
		System.out.println("Implement second Test case here !");
		Util = new Utilities(driver);
		Util.scrollToText("Recipes");
	}
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}*/
	
}
