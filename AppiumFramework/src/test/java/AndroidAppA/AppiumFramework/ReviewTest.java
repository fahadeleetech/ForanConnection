package AndroidAppA.AppiumFramework;
//import static org.testng.Assert.assertEquals;

import static java.time.Duration.ofMillis;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.internal.TouchAction;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountScreen;
import PageObjects.EditProfileScreen;
import PageObjects.HomeScreen;
import PageObjects.IntroScreen;
import PageObjects.LUHFUScreen;
import PageObjects.LoginScreen;
import PageObjects.Reveiw;
import PageObjects.SearchScreen;
import PageObjects.VendorProfileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static java.time.Duration.ofSeconds;
public class ReviewTest extends Base {
	public static AndroidDriver<AndroidElement> driver;
	public static IntroScreen intro; 
	public static HomeScreen home;
	public static LoginScreen login;
	public static AccountScreen account;
	public static EditProfileScreen profile;
	public static LUHFUScreen luhfu;
	public static SearchScreen searchbar;
	public static Reveiw review;
	public static VendorProfileScreen vendorprofile;
	String ratio= "9.0";
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
		searchbar = new SearchScreen(driver);
		review = new Reveiw(driver);
		vendorprofile = new VendorProfileScreen(driver);
	}
	

	@Test(priority=1)
	public void login() throws IOException, InterruptedException
		{
		intro.skipBtn.click();
		home.locationPopup.click();
		home.introShowCase.click();
		home.profileIcon.click();
		home.loginPopup.click();
		login.emailField.sendKeys("aqtesting2524@gmail.com");
		login.passwordField.sendKeys("12345@Azs");
		if(login.loginBtn.isEnabled() == true)
			{
				login.loginBtn.click();
			}
		}
@Test(priority=2)
public void search() {
	searchbar.HomeSearchbar.click();
	searchbar.aroundMeIcon.click();
	searchbar.Aroundmeshowcase.click();
	searchbar.HomeAddress.click();
	searchbar.searchedText.sendKeys("haseeb test");
	String searchvendor = searchbar.searchedText.getAttribute("text");
	String searchsuggestion = searchbar.vendorname.getAttribute("text");
	
		searchbar.vendorname.click();
		Assert.assertEquals(searchsuggestion, searchvendor);
	String searchcard = searchbar.firstSearchedCard.getAttribute("text");
	Assert.assertEquals(searchsuggestion, searchcard);
	searchbar.firstSearchedCard.click();
	
}
@Test(priority=3)
public void catagory() 
	{
	vendorprofile.reviewIcon.click();
	review.categorytitle.click();
	review.catagoryACMechanic.click();
	review.categorytitle.click();
	
	}
@Test(priority =4)
public void completiondate() {
	
	review.completiondate.click();
	review.dateselect.click();
	review.completiondate.click();
	
}
@Test(priority =5) 
public void amount()
{
	review.costofproject.click();
	review.price.clear();
	review.price.sendKeys("1000");
	review.costofproject.click();
}
@Test(priority =6) 
public void comment()
{
	review.addcomment.click();
	review.comment.clear();
	review.comment.sendKeys("Great Work");
	review.addcomment.click();
}
@Test(priority =7) 
public void scroll()
{

	WebElement sc=driver.findElementByXPath("//android.widget.ScrollView[@bounds='[28,476][1052,1714]']");
	Dimension dm = sc.getSize();
	int startX = (int) (dm.width*0.5); 
	int startY = (int) (dm.height*0.8); 
	int endX = (int) (dm.width*0.2); 
	int endY = (int) (dm.height*0.2); 
	AndroidTouchAction ta = new AndroidTouchAction(driver);
	ta.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
	.moveTo(PointOption.point(endX,endY) ).release().perform();
		//Thread.sleep(3000);
	
		review.photoicon.click();
	review.allowbtn.click();
	review.insidecamera.click();
	review.applyimage.click();
}
@Test(priority =8) 
public void stars()
{
	//review.ratingbar.click();
	//review.ratingbar.clear();
	review.ratingbar.sendKeys("9.0");
	review.ratingbar.click();
}
@Test(priority =9) 
public void submit()
{
	review.submitbtn.click();
}
@Test(priority =10) 
public void confirmreview()
{
	review.yes.click();
}
@Test(priority =11) 
public void verify()
{
	review.reviewbtn.click();
	String textR = review.textReview.getAttribute("text");
	System.out.println("Reveiw added"+ textR + "Stars");
	
}
}
