package AndroidAppA.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AccountScreen;
import PageObjects.EditProfileScreen;
import PageObjects.HomeScreen;
import PageObjects.IntroScreen;
import PageObjects.LoginScreen;
import PageObjects.SavedPlacesScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SmokeTestScenarios extends Base{
	public static AndroidDriver<AndroidElement> driver;
	public static IntroScreen intro; 
	public static HomeScreen home;
	public static LoginScreen login;
	public static AccountScreen account;
	public static EditProfileScreen userProfile;
	public static SavedPlacesScreen address;
	
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
		userProfile = new EditProfileScreen(driver);
		
	}

	@Test
	public void login()
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
			//WebDriverWait waitLoginBtn = new WebDriverWait(driver, 2);
			//waitLoginBtn.until(ExpectedConditions.invisibilityOfElementLocated((By) login.loginBtn.));
			
			home.profileIcon.click();
			home.introShowCase.click();
			account.profileImage.click();
			String loginCheck = userProfile.emailAddress.getAttribute("text");
			Assert.assertEquals("fadiformanite@gmail.com", loginCheck);
		}
	
			
	
	@Test
	public void profileManagement()
		{				
			userProfile.firstName.clear();
			userProfile.firstName.sendKeys("Bilal1");
			userProfile.lastName.clear();
			userProfile.lastName.sendKeys("Ashraf1");
			userProfile.mobileNumber.clear();
			userProfile.mobileNumber.sendKeys("3214204301");
				if(userProfile.updateBtn.isEnabled() == true)
				{
					userProfile.updateBtn.click();
				}
			String profileUpdateMessage = userProfile.updateToastMessage.getAttribute("name");
			Assert.assertEquals("Updated Successfully", profileUpdateMessage);
			
			userProfile.backBtn.click();
			account.profileImage.click();
			
			String fNameVerification = userProfile.firstName.getAttribute("text");
			Assert.assertEquals("Bilal1", fNameVerification);
			
			String lNameVerification = userProfile.lastName.getAttribute("text");
			Assert.assertEquals("Ashraf1", lNameVerification);
			
			String mobileNumberVerification = userProfile.mobileNumber.getAttribute("text");
			Assert.assertEquals("3214204301", mobileNumberVerification);
		}
	
	@Test
	public void homeAddressSetting()
		{				
			userProfile.backBtn.click();
			account.addressBtn.click();
			address.homeBtn.click();
			address.adjustMapBtn.click();
			address.locationSearchField.click();
			address.locationSearchField.sendKeys("iqbal town");
			address.locationSelection.click();
			address.confirmBtn.click();
			
			WebDriverWait waitHome = new WebDriverWait(driver, 5);
			waitHome.until(ExpectedConditions.elementToBeClickable(address.updateHomeBtn));
			
			address.updateHomeBtn.click();
			
			String homeAddressUpdateMessage = address.updateHomeToastMessage.getAttribute("name");
			Assert.assertEquals("Home updated successfully.", homeAddressUpdateMessage);
		}
	
	@Test
	public void workAddressSetting() 
		{
			address.workBtn.click();
			address.adjustMapBtn.click();
			address.locationSearchField.click();
			address.locationSearchField.sendKeys("awan town");
			address.locationSelection.click();
			address.confirmBtn.click();	
			
			WebDriverWait waitWork = new WebDriverWait(driver, 5);
			waitWork.until(ExpectedConditions.elementToBeClickable(address.updateWorkBtn));
			
			address.updateWorkBtn.click();
			
			String workAddressUpdateMessage = address.updateWorkToastMessage.getAttribute("name");
			Assert.assertEquals("Work updated successfully.", workAddressUpdateMessage);
				
		}
	
	@Test
	public void customAddressSetting()
		{
			address.addNewAddressIcon.click();
			address.adjustMapBtn.click();
			address.locationSearchField.click();
			address.locationSearchField.sendKeys("sabzazar");
			address.locationSelection.click();
			address.confirmBtn.click();	
			address.addCustomAddressName.click();
			address.addCustomAddressName.sendKeys("testHome1");
			
			WebDriverWait waitCustom = new WebDriverWait(driver, 5);
			waitCustom.until(ExpectedConditions.elementToBeClickable(address.addPlaceBtn));
			
			address.addPlaceBtn.click();
			
			String customAddressUpdateMessage = address.addCustomAddressToastMessage.getAttribute("name");
			Assert.assertEquals("Location added to saved places.", customAddressUpdateMessage);
			
			String customAddressVerification = address.addedCustomAddressName.getAttribute("text");
			Assert.assertEquals("testHome1", customAddressVerification);
			
		
		}
	
	@AfterClass
	public void tearDown()
	{
		service.stop();
	}
	

}
