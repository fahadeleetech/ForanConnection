package AndroidAppA.AppiumFramework;

import java.io.IOException;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountScreen;
import PageObjects.BrowseAllPO;
import PageObjects.HomeScreen;
import PageObjects.IntroScreen;
import PageObjects.LoginScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class BrowseAll extends Base {

	public static AndroidDriver<AndroidElement> driver;
	 
	public static HomeScreen HomeScreen;
	public static AccountScreen AccountScreen;
	public static BrowseAllPO BrowseAll;
	public static LoginScreen LoginScreen;
	public static IntroScreen IntroScreen;
	

	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service = startServer();
		driver = capabilities("appA");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		IntroScreen = new IntroScreen(driver);
		HomeScreen = new HomeScreen(driver);
		LoginScreen = new LoginScreen(driver);
		AccountScreen = new AccountScreen(driver);
		BrowseAll = new BrowseAllPO(driver);
		
	}

@Test (priority=1)
	public void login() 
		{
	IntroScreen.skipBtn.click();
		HomeScreen.locationPopup.click();
		HomeScreen.introShowCase.click();
		HomeScreen.profileIcon.click();
		HomeScreen.loginPopup.click();
		LoginScreen.emailField.sendKeys("haseeb30@yopmail.com");
		LoginScreen.passwordField.sendKeys("Haseeb@3");
		if(LoginScreen.loginBtn.isEnabled() == true)
			{
			LoginScreen.loginBtn.click();
			}
		}
	
@Test (priority=2)
public void browseAll() 
	{
	
	BrowseAll.BrowseAllButton.click();
	BrowseAll.Electrician.click();
	BrowseAll.AroundMe.click();
	BrowseAll.ShowCaseButton.click();
	BrowseAll.HomeAddress.click();
	driver.navigate().back();
	
	BrowseAll.Boring.click();
	BrowseAll.AroundMe.click();
	BrowseAll.HomeAddress.click();
	driver.navigate().back();
	
	BrowseAll.DoorWorks.click();
	BrowseAll.AroundMe.click();
	BrowseAll.HomeAddress.click();
	driver.navigate().back();
	
	BrowseAll.GlassDesigner.click();
	BrowseAll.AroundMe.click();
	BrowseAll.HomeAddress.click();
	driver.navigate().back();
	
	

	}
	


}
