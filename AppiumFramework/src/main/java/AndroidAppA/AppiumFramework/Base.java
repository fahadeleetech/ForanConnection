package AndroidAppA.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	// This method will start the server and if it is already running that it will return the started service
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag)
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
	// This method will check if server is running or not
	public static boolean checkIfServerIsRunning(int port) 
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try 
			{
				serverSocket = new ServerSocket(port);
				serverSocket.close();
			}
		catch (IOException e)
			{
				//if control comes here then port is in use
				isServerRunning = true;
			}
		finally
			{
				serverSocket = null;
			}
		return isServerRunning;		
	}

	// This method will start the emulator
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
	// This method will give capabilities to the driver and tells which application to start
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AndroidAppA\\AppiumFramework\\global.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		
		
		File appDir = new File("src");
		File app = new File(appDir,(String) prop.get(appName));
		String device = (String) prop.get("device");
		if(device.contains("Emulator"))
		{
			startEmulator();
		}
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	

	}
	
	public static void getScreenShot(String testName) throws IOException 
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\"+testName+".png"));	 
	}

}
