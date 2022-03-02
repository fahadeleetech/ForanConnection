package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VendorProfileScreen {
	public String confirmPopupText = "Please mention Foran Connection when you connect with the vendor for a possible discount";
	
	public VendorProfileScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Call']")
	public WebElement callIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Message']")
	public WebElement messageIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Review']")
	public WebElement reviewIcon;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	public WebElement allowPopup;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/txt_dia")
	public WebElement confirmPopup;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Call']")
	public WebElement confirmPopupCallBtn;
	
	@AndroidFindBy(id = "com.android.dialer:id/incall_end_call")
	public WebElement endCallBtn;
	

}
