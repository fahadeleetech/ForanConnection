package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class JobScreen {
	public JobScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Upcoming']")
	public WebElement Upcomming;
	//com.el33tech.serviceproviders:id/tv_repot  ⋮
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/linear_row")
	public WebElement Jobbanner;
	@AndroidFindBy( id = "com.android.packageinstaller:id/permission_allow_button")
	public WebElement allowbtn;
	@AndroidFindBy( id = "com.el33tech.serviceproviders:id/tv_description")
	public WebElement jobDescription;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='⋮']")
	public WebElement ViewOption;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove']")
	public WebElement remove;
	@AndroidFindBy( id = "com.el33tech.serviceproviders:id/st_manual_reason")
	public WebElement Reason;
	@AndroidFindBy( id = "com.el33tech.serviceproviders:id/tv_repot")
	public WebElement yesbtnreson;
	//android.widget.TextView
	
}
