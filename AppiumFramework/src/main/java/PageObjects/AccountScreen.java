package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountScreen {
	
	public AccountScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/profile_image")
	public WebElement profileImage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Address']")
	public WebElement addressBtn;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/linear_back")
	public WebElement backBtn;
	
	

}
