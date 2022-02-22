package AndroidAppA.AppiumFramework;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
//kimport org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class WalkThroughScreens extends Base{
	public static AndroidDriver<AndroidElement> driver;
	
	
	public static PageObjects.WalkThroughScreen wts;

	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service = startServer();
		driver = capabilities("appA");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wts = new PageObjects.WalkThroughScreen(driver);
		
	}

    /*@Test(priority =1)
	public void WalkThroughScreen() throws IOException, InterruptedException
		{
		for (int  i =0;  i <=4;i++) {
		wts.walkcall(driver);
		}}*/
		
@Test(priority=1)
	public void firstscreen() throws InterruptedException {
		String heading =wts.headingfirst.getAttribute("text");
		String detail = wts.detailtext.getAttribute("text");
		Assert.assertEquals("People Trusted Platform", heading);
		Assert.assertEquals("Review vendor profiles based on their ratings, reach several trusted service providers in your area so you’ll be more confident about to whom you’re going to call.", detail);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wts.walkcall(driver);
		
	}
@Test(priority=2)
public void secondscreen() throws InterruptedException {
	String heading =wts.headingfirst.getAttribute("text");
	String detail = wts.detailtext.getAttribute("text");
	Assert.assertEquals("Connect Instantly, Anytime, And Anywhere", heading);
	Assert.assertEquals("24/7 availability to get access to the service providers, and allows you to connect from anywhere, to get your job done fast and hassle-free.", detail);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wts.walkcall(driver);
	
}
@Test(priority=3)
public void thirdscreen() throws InterruptedException {
	String heading =wts.headingfirst.getAttribute("text");
	String detail = wts.detailtext.getAttribute("text");
	Assert.assertEquals("Find Nearest Service Providers", heading);
	Assert.assertEquals("No need to go outside in summer heat or cold weather. Just turn on your location to get the nearest service provider details in your area “Foran Sai Bhi Pehle”", detail);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wts.walkcall(driver);
	
}
@Test(priority=4)
public void fourthscreen() throws InterruptedException {
	String heading =wts.headingfirst.getAttribute("text");
	String detail = wts.detailtext.getAttribute("text");
	Assert.assertEquals("Contact Your Service Provider", heading);
	Assert.assertEquals("Find the best service provider and straight away get him on the call, to describe the job.", detail);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wts.walkcall(driver);
	
}
@Test(priority=5)
public void fifthscreen() throws InterruptedException {
	String heading =wts.headingfirst.getAttribute("text");
	String detail = wts.detailtext.getAttribute("text");
	Assert.assertEquals("Let us hire for you!", heading);
	Assert.assertEquals("Not sure how to use the app or couldn’t find the best service provider “Just Sit Back and Relax” give us a little brief about your job and we’ll connect you with the right service provider as soon as possible.", detail);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wts.walkcall(driver);
	
}

	

   @Test(priority =6)
	public void Getstarted() {
		wts.GetStartedbtn.click();
    
}
    }