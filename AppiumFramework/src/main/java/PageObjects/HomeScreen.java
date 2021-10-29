package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen {
	
	public HomeScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/profile_image")
	public WebElement profileIcon;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='WHILE USING THE APP']")
	public WebElement locationPopup;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/imageViewShowCaseClose")
	public WebElement introShowCase;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
	public WebElement loginPopup;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/rel_left_half")
	public WebElement luhfuBtn;
	

}
