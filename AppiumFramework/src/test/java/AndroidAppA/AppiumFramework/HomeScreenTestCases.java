package AndroidAppA.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.HomeScreen;
import PageObjects.IntroScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeScreenTestCases extends Base{
	public static AndroidDriver<AndroidElement> driver;
	public static IntroScreen intro; 
	public static HomeScreen home;
	
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
		
	}

	@Test (priority=1)
	public void verifyElectricianCategory()
		{
			intro.skipBtn.click();
			home.locationPopup.click();
			home.introShowCase.click();
			
			String verifyElectricianIcon = home.electricianIcon.getAttribute("text");
			System.out.println(verifyElectricianIcon);
			Assert.assertEquals("Electrician", verifyElectricianIcon);
		}
	
	
	@Test (priority=2)
	public void verifyHeatingAndCoolingCategory()
		{
			String verifyHeatingAndCoolingIcon = home.heatingAndCoolingIcon.getAttribute("text");
			System.out.println(verifyHeatingAndCoolingIcon);
			Assert.assertEquals("Heating & Cooling", verifyHeatingAndCoolingIcon);
		}
	
	@Test (priority=3)
	public void verifyPlumberCategory()
		{	
			String verifyPlumberIcon = home.plumberIcon.getAttribute("text");
			System.out.println(verifyPlumberIcon);
			Assert.assertEquals("Plumber", verifyPlumberIcon);
		}
	
	@Test (priority=4)
	public void verifyElectronicsAndRepairCategory()
	{	
		String verifyElectronicsAndRepairIcon = home.electronicsAndRepairIcon.getAttribute("text");
		System.out.println(verifyElectronicsAndRepairIcon);
		Assert.assertEquals("Electronics & Repair", verifyElectronicsAndRepairIcon);
	}
	
	@Test (priority=5)
	public void verifyHandyManCategory()
	{	
		String verifyHandymanIcon = home.handymanIcon.getAttribute("text");
		System.out.println(verifyHandymanIcon);
		Assert.assertEquals("Handyman", verifyHandymanIcon);
	}
	
	@Test (priority=5)
	public void verifyPainterCategory()
	{	
		String verifyPainterIcon = home.painterIcon.getAttribute("text");
		System.out.println(verifyPainterIcon);
		Assert.assertEquals("Painter", verifyPainterIcon);
	}
	
	@Test (priority=6)
	public void verifyCarpenterCategory()
	{	
		String verifyCarpenterIcon = home.carpenterIcon.getAttribute("text");
		System.out.println(verifyCarpenterIcon);
		Assert.assertEquals("Carpenter", verifyCarpenterIcon);
	}
	
	@Test (priority=7)
	public void verifyGlassWorksCategory()
	{	
		String verifyGlassWorksIcon = home.glassWorksIcon.getAttribute("text");
		System.out.println(verifyGlassWorksIcon);
		Assert.assertEquals("Glass Works", verifyGlassWorksIcon);
	}
	
	@Test (priority=8)
	public void verifyOtherCategory()
	{	
		String verifyOtherIcon = home.otherIcon.getAttribute("text");
		System.out.println(verifyOtherIcon);
		Assert.assertEquals("Other", verifyOtherIcon);
	}
	
	@Test (priority=9)
	public void verifyLuhfuBtn()
	{	
		String verifyLuhfuBtn = home.luhfuBtnText.getAttribute("text");
		System.out.println(verifyLuhfuBtn);
		Assert.assertEquals("Let Us Hire For You!", verifyLuhfuBtn);
	}
	
	@Test (priority=10)
	public void verifyPopularServices()
	{	
		String verifyPopularServicesText = home.popularServicesText.getAttribute("text");
		System.out.println(verifyPopularServicesText);
		Assert.assertEquals("Popular services", verifyPopularServicesText);
	}
	
	@Test (priority=11)
	public void verifySearchTab()
	{	
		String verifySearchTabText = home.searchTab.getAttribute("text");
		System.out.println(verifySearchTabText);
		Assert.assertEquals("Search", verifySearchTabText);
	}
	
	@Test (priority=12)
	public void verifyFavouriteTab()
	{	
		String verifyFavouriteTabText = home.favouriteTab.getAttribute("text");
		System.out.println(verifyFavouriteTabText);
		Assert.assertEquals("Favourite", verifyFavouriteTabText);
	}
	
	@Test (priority=13)
	public void verifyHiresTab()
	{	
		String verifyHiresTabText = home.hiresTab.getAttribute("text");
		System.out.println(verifyHiresTabText);
		Assert.assertEquals("Hires", verifyHiresTabText);
	}
	
	@Test (priority=14)
	public void verifyFindAPro()
	{	
		String verifyFindaProText = home.findaProText.getAttribute("text");
		System.out.println(verifyFindaProText);
		Assert.assertEquals("Find a Pro", verifyFindaProText);
	}
	
	@Test (priority=15)
	public void verifyCurrentlyForLahoreOnly()
	{	
		String verifyCurrentlyForLahoreOnlyText = home.currentlyForLahoreOnlyText.getAttribute("text");
		System.out.println(verifyCurrentlyForLahoreOnlyText);
		Assert.assertEquals("Currently for Lahore only", verifyCurrentlyForLahoreOnlyText);
	}
	
	@Test (priority=16)
	public void verifyHomeFooter()
	{	
		String verifyHomeFooter = home.homeFooter.getAttribute("text");
		System.out.println(verifyHomeFooter);
		Assert.assertEquals("Home", verifyHomeFooter);
	}
		
	@AfterClass
	public void tearDown()
	{
		service.stop();
	}
}
