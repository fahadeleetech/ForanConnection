package AndroidAppA.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AppiumDriverLocalService service;
	
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

	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AndroidAppA\\AppiumFramework\\global.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		AndroidDriver<AndroidElement> driver;
		
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

}

//command to kill all the ports, open cmd and paste this command
// taskkill /F /IM node.exe
