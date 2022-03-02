package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen {
	public String email = "fadiformanite@gmail.com";
	public String password = "webdir123R!";
	
	public LoginScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
	public WebElement emailField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
	public WebElement passwordField;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
	public WebElement loginBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
	public WebElement loginPopup;

}
