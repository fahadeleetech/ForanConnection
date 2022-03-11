package AndroidAppA.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AccountScreen;
import PageObjects.EditProfileScreen;
import PageObjects.HomeScreen;
import PageObjects.IntroScreen;
import PageObjects.JobScreen;
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
	public static JobScreen job;
	public String description ;
	public String address3step ;
	public String phone3step ; 
	
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
	@Test (priority=1)
	public void login() throws IOException, InterruptedException
		{
		intro.skipBtn.click();
		home.locationPopup.click();
		home.introShowCase.click();
		home.profileIcon.click();
		home.loginPopup.click();
		login.emailField.sendKeys(luhfu.email);
		login.passwordField.sendKeys(luhfu.password);
		if(login.loginBtn.isEnabled() == true)
			{
				login.loginBtn.click();
			}
		}
	
	@Test (priority=2)
	public void luhfuStep1() throws IOException
		{				
		 	
			home.luhfuBtn.click();
			luhfu.closebtn.click();
			home.luhfuBtn.click();
			luhfu.Resetbtn.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			luhfu.Reset.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			luhfu.electricianCategory.click();
			if(luhfu.continueBtn.isEnabled() == true)
			{
				luhfu.continueBtn.click();
			}
		}
	
	@Test (priority=3)
	public void luhfuStep2() throws IOException
		{				
		 	
			luhfu.descriptionField.clear();
			luhfu.descriptionField.sendKeys(luhfu.jobDescription);

			if(luhfu.continueBtn.isEnabled() == true)
			{
				luhfu.continueBtn.click();
			}}
			@Test (priority=4)
			public void luhfuStep3() throws IOException
				{		
				phone3step    = luhfu.phone3luhfu.getAttribute("text");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				luhfu.adjustfrommap.click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				luhfu.showcaseclose.click();
				
				luhfu.removetextfromsearch.click();
				luhfu.tabsearchbar.click();
				luhfu.searchlocation.sendKeys(luhfu.location);
				 luhfu.searchsuggestion.click();
				luhfu.confirmbtn.click();
				address3step = luhfu.luhfu3AddressText.getAttribute("text");
				if(luhfu.continueBtn.isEnabled() == true)
				{
					luhfu.continueBtn.click();
				}
		}
			@Test (priority=5)
			public void luhfuStep4() throws IOException
				{				
				 	
				luhfu.amount.sendKeys(luhfu.budget);
				if(luhfu.continueBtn.isEnabled() == true)
				{
					luhfu.continueBtn.click();
				}
		}
			@Test (priority=6)
			public void luhfuStep5() throws IOException
				{				
				 	luhfu.submit.click();
				
		}
			@Test (priority=7)
			public void confirmationpopup() throws IOException
				{		
				String Confirmbox =   luhfu.verifydescription.getAttribute("text");
				Assert.assertEquals(description, Confirmbox);
				String catagoryconfirm =   luhfu.catagorynameConfirmjob.getAttribute("text");
				Assert.assertEquals(luhfu.electricianCategory.getAttribute("text"), catagoryconfirm);
				String addressconfirm =   luhfu.confirmjobpopupaddress.getAttribute("text");
			   Assert.assertEquals(address3step , addressconfirm);
				String bugdetconfirm =   luhfu.budgettext.getAttribute("text");
				Assert.assertEquals(luhfu.budget, bugdetconfirm);
				String phoneconfirm =   luhfu.phoneconfirmjob.getAttribute("text");
				Assert.assertEquals("+92"+phone3step, phoneconfirm);
				 	luhfu.yes.click();
				
		}
		/*	@Test (priority=8)
			public void verifyjob() throws IOException
				{				
				 home.jobbtn.click();
				 job.Upcomming.click();
				job.Jobbanner.click();
				job.allowbtn.click();
				job.Jobbanner.click();
				String jobdes = job.jobDescription.getAttribute("text");
				Assert.assertEquals(description, jobdes);
		}
			@Test (priority=9)
			public void Removejob() throws IOException
				{				
				job.ViewOption.click();
				job.remove.click();
				job.Reason.sendKeys("No Need ");
				job.yesbtnreson.click();
		}*/

			
			

}
