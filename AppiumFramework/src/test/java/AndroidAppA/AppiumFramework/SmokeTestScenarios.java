package AndroidAppA.AppiumFramework;
import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountScreen;
import PageObjects.EditProfileScreen;
import PageObjects.HomeScreen;
import PageObjects.IntroScreen;
import PageObjects.LoginScreen;
import PageObjects.SavedPlacesScreen;
import PageObjects.SearchScreen;
import PageObjects.VendorProfileScreen;
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
	public static SearchScreen search;
	public static VendorProfileScreen vendorProfile;
	
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
		search = new SearchScreen(driver);
		address = new SavedPlacesScreen(driver);
		vendorProfile = new VendorProfileScreen(driver);
		
	}

	@Test (priority=1)
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

			WebDriverWait waitprofileIcon = new WebDriverWait(driver, 5);
			waitprofileIcon.until(ExpectedConditions.elementToBeClickable(home.profileIcon));
			
			home.profileIcon.click();
			home.introShowCase.click();
			account.profileImage.click();
			String loginCheck = userProfile.emailAddress.getAttribute("text");
			Assert.assertEquals("fadiformanite@gmail.com", loginCheck);
		}
	
			
	
	@Test (priority=2)
	public void profileManagement()
		{
			userProfile.firstName.clear();
			userProfile.firstName.sendKeys("Bilal "+LocalTime.now().getSecond());
			userProfile.lastName.clear();
			userProfile.lastName.sendKeys("Ashraf1");
			userProfile.mobileNumber.clear();
			//userProfile.mobileNumber.sendKeys("3214204301");
				if(userProfile.updateBtn.isEnabled() == true)
				{
					userProfile.updateBtn.click();
				}
			String profileUpdateMessage = userProfile.updateToastMessage.getAttribute("name");
			Assert.assertEquals("Updated Successfully", profileUpdateMessage);
			
			userProfile.backBtn.click();
			account.profileImage.click();
			
			String lNameVerification = userProfile.lastName.getAttribute("text");
			Assert.assertEquals("Ashraf1", lNameVerification);
			
			String mobileNumberVerification = userProfile.mobileNumber.getAttribute("text");
			Assert.assertEquals("3214204301", mobileNumberVerification);
			
		}
	
	@Test (priority=3)
	public void homeAddressSetting()
		{			
			userProfile.backBtn.click();
			account.addressBtn.click();
			
			WebDriverWait homeBtn = new WebDriverWait(driver, 5);
			homeBtn.until(ExpectedConditions.elementToBeClickable(address.homeBtn));
			
			address.homeBtn.click();
			address.adjustMapBtn.click();
			address.locationSearchField.click();
			address.editlocationSearchField.sendKeys("iqbal town");
			address.locationSelection.click();
			address.confirmBtn.click();
			
			WebDriverWait waitHome = new WebDriverWait(driver, 5);
			waitHome.until(ExpectedConditions.elementToBeClickable(address.updateHomeBtn));
			
			address.updateHomeBtn.click();
			
			String homeAddressUpdateMessage = address.updateHomeToastMessage.getAttribute("name");
			Assert.assertEquals("Home updated successfully.", homeAddressUpdateMessage);
		}
	
	@Test (priority=4)
	public void workAddressSetting() 
		{
			address.workBtn.click();
			address.adjustMapBtn.click();
			address.locationSearchField.click();
			address.editlocationSearchField.sendKeys("awan town");
			address.locationSelection.click();
			address.confirmBtn.click();	
			
			WebDriverWait waitWork = new WebDriverWait(driver, 5);
			waitWork.until(ExpectedConditions.elementToBeClickable(address.updateWorkBtn));
			
			address.updateWorkBtn.click();
			
			String workAddressUpdateMessage = address.updateWorkToastMessage.getAttribute("name");
			Assert.assertEquals("Work updated successfully.", workAddressUpdateMessage);
				
		}
	
	@Test (priority=5)
	public void customAddressSetting()
		{
			address.addNewAddressIcon.click();
			address.adjustMapBtn.click();
			address.locationSearchField.click();
			address.editlocationSearchField.sendKeys("sabzazar");
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
			
			address.verticalDots.click();
			address.removeBtn.click();
			address.yesBtn.click();
			
			//String locationDeletedMessage = address.locationDeletedToastMessage.getAttribute("name");
			//Assert.assertEquals("Location Deleted!", locationDeletedMessage);
			
		
		}
	
	@Test (priority=6)
	public void searchByCategory()
		{
		   WebDriverWait waitbackBtn = new WebDriverWait(driver, 7);
		   waitbackBtn.until(ExpectedConditions.elementToBeClickable(address.backBtn));
		
			address.backBtn.click();
			account.backBtn.click();
			home.electricianIcon.click();
			search.aroundMeIcon.click();
			home.introShowCase.click();
			address.homeBtn.click();
			
			int electricianCategoryCount = 0;
			int allCategoryCount = search.displayedCategories.size();
			int vendorCount = search.displayedVendors.size();
			for (int i = 0; i< allCategoryCount; i++)
				{
					String text = search.displayedCategories.get(i).getText();
						if(text.equalsIgnoreCase("Electrician"))
							{
								electricianCategoryCount++;
							}
						else
							{
								continue;
							}
				}
			Assert.assertEquals(vendorCount, electricianCategoryCount);
						
		}
	
	@Test (priority=7)
	public void searchByTyping()
		{
			search.searchField.clear();
			search.searchField.sendKeys("Madina traders");
			
			WebDriverWait waitVendor = new WebDriverWait(driver, 7);
			waitVendor.until(ExpectedConditions.elementToBeClickable(search.firstSearchSuggestion));
			
			search.firstSearchSuggestion.click();
			
			String searchedVendorText = search.searchedText.getAttribute("text");
			String searchedVendorVerification = search.firstSearchedCard.getAttribute("text");
			Assert.assertEquals(searchedVendorText, searchedVendorVerification);
			
		}
	
	@Test (priority=8)
	public void callVendor()
		{
			search.firstSearchedCard.click();
			
			WebDriverWait waitCall = new WebDriverWait(driver, 3);
			waitCall.until(ExpectedConditions.visibilityOf(vendorProfile.callIcon));
			
			String callIconVerification =vendorProfile.callIcon.getAttribute("text");
			Assert.assertEquals("Call", callIconVerification);
			
			String messageIconVerification = vendorProfile.messageIcon.getAttribute("text");
			Assert.assertEquals("Message", messageIconVerification);
			
			String reviewIconVerification = vendorProfile.reviewIcon.getAttribute("text");
			Assert.assertEquals("Review", reviewIconVerification);
			
			vendorProfile.callIcon.click();
			driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
			
			
			String callTextVerification = driver.findElement(By.id("com.el33tech.serviceproviders:id/txt_dia")).getAttribute("text");
			//System.out.println(callTextVerification);
			Assert.assertEquals("Please mention Foran Connection when you connect with the vendor for a possible discount", callTextVerification);
			

			driver.findElementByXPath("//android.widget.TextView[@text='Call']").click();
			driver.findElementById("com.android.dialer:id/incall_end_call").click();
			
		}
	
	@AfterClass
	public void tearDown()
	{
		service.stop();
	}
}
