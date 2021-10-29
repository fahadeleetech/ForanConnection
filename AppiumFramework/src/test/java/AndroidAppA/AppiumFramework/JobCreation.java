package AndroidAppA.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AccountScreen;
import PageObjects.EditProfileScreen;
import PageObjects.HomeScreen;
import PageObjects.IntroScreen;
import PageObjects.LUHFUScreen;
import PageObjects.LoginScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class JobCreation extends Base{
	public static AndroidDriver<AndroidElement> driver;
	public static IntroScreen intro; 
	public static HomeScreen home;
	public static LoginScreen login;
	public static AccountScreen account;
	public static EditProfileScreen profile;
	public static LUHFUScreen luhfu;
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service = startServer();
		driver = capabilities("appA");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		intro = new IntroScreen(driver);
		home = new HomeScreen(driver);
		login = new LoginScreen(driver);
		account = new AccountScreen(driver);
		profile = new EditProfileScreen(driver);
		luhfu = new LUHFUScreen(driver);
		
	}

	@Test
	public void login() throws IOException, InterruptedException
		{
		intro.skipBtn.click();
		home.locationPopup.click();
		home.introShowCase.click();
		home.profileIcon.click();
		home.loginPopup.click();
		login.emailField.sendKeys("fadiformanite@gmail.com");
		login.passwordField.sendKeys("webdir123R@");
		if(login.loginBtn.isEnabled() == true)
			{
				login.loginBtn.click();
			}
		}
	
	@Test
	public void luhfuStep1() throws IOException
		{				
		 	
			home.luhfuBtn.click();
			luhfu.electricianCategory.click();
			if(luhfu.continueBtn.isEnabled() == true)
			{
				luhfu.continueBtn.click();
			}
		}
	
	@Test
	public void luhfuStep2() throws IOException
		{				
		 	
			luhfu.descriptionField.clear();
			luhfu.descriptionField.sendKeys("My issue is i need electrician to fix my fan");
			if(luhfu.continueBtn.isEnabled() == true)
			{
				luhfu.continueBtn.click();
			}
		}
	
	@AfterClass
	public void tearDown()
	{
		service.stop();
	}
	

}
