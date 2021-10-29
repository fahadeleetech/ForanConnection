package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditProfileScreen {
	
	public EditProfileScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/detail_fname")
	public WebElement firstName;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/detail_lname")
	public WebElement lastName;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/detail_phone")
	public WebElement mobileNumber;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/detail_email")
	public WebElement emailAddress;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/bt_update")
	public WebElement updateBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement updateToastMessage;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/iv_back")
	public WebElement backBtn;
	
}
