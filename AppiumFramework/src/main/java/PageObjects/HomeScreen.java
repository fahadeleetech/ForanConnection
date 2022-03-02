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
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electrician']")
	public WebElement electricianIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Plumber']")
	public WebElement plumberIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Carpenter']")
	public WebElement carpenterIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electronics & Repair']")
	public WebElement electronicsAndRepairIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Handyman']")
	public WebElement handymanIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Painter']")
	public WebElement painterIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Heating & Cooling']")
	public WebElement heatingAndCoolingIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Glass Works']")
	public WebElement glassWorksIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Other']")
	public WebElement otherIcon; 
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cleaning']")
	public WebElement cleaningIcon; 
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cook']")
	public WebElement cookIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	public WebElement homeFooter;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
	public WebElement searchTab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Favourite']")
	public WebElement favouriteTab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hires']")
	public WebElement hiresTab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Find a Pro']")
	public WebElement findaProText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Currently for Lahore only']")
	public WebElement currentlyForLahoreOnlyText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular services']")
	public WebElement popularServicesText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Let Us Hire For You!']")
	public WebElement luhfuBtnText;
	

}
