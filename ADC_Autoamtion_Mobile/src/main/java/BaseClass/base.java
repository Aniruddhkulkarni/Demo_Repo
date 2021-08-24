package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	//public static AndroidDriver<AndroidElement> driver;
	private static EnhancedAndroidDriver<MobileElement> driver;
	public static EnhancedAndroidDriver<MobileElement> capabilities(String appName) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Reuseable\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		 String device=(String) prop.get("deviceName");
		//String device = System.getProperty("deviceName");
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("appPackage","com.applieddatacorp.upshop");
		capabilities.setCapability("appActivity","crc645faa085c4457de04.SplashActivity");
		//driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = Factory.createAndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	/*public static void getScreenshot(String s) throws IOException 
	{
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));

	}*/
	
	// Start Appium server Automatically 
		public static AppiumDriverLocalService startServer() 
		{
			boolean flag = checkIfServerIsRunnning(4723);
			if (!flag) 
			{
				service = AppiumDriverLocalService.buildDefaultService();
				service.start();
			}
			return service;
		}
		//Before Starting Appium Server Check if Appium server is running already
		public static boolean checkIfServerIsRunnning(int port) {

			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);

				serverSocket.close();
			} catch (IOException e) {
				// If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
		}
	   //Start Emulator automatically
		public static void startEmulator() throws IOException, InterruptedException {

			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
			Thread.sleep(6000);
		}


}