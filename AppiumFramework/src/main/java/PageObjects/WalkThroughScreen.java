package PageObjects;

import static java.time.Duration.ofMillis;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class WalkThroughScreen {
	
	public WalkThroughScreen(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/viewPager")
	public static WebElement walk;

	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/bt_get_started")
	public WebElement GetStartedbtn; 
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_get_start")
	public WebElement headingfirst; 
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_plumber")
	public WebElement detailtext;
	public void walkcall(MobileDriver driver) throws InterruptedException {
	WebDriverWait wait1 = new WebDriverWait(driver, 20);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.el33tech.serviceproviders:id/viewPager")));
       WebElement panel = walk;
	Dimension d = panel.getSize();
	int anchor = panel.getSize().getHeight()/2;
	Double screenStartWidth = d.getWidth()*0.8;
	int scrollstart = screenStartWidth.intValue();
	
	Double screenEndWidth = d.getWidth()*0.2;
	int scrollEnd = screenEndWidth.intValue();
	TouchAction ta = new TouchAction((PerformsTouchActions)driver);
ta.press(PointOption.point(scrollstart, anchor)).waitAction(WaitOptions.waitOptions(ofMillis(250)))
.moveTo(PointOption.point(scrollEnd,anchor) ).release().perform();
	Thread.sleep(3000);}
}
