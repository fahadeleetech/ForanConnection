package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LUHFUScreen {
	public String budget = "100.0 PKR"; 
	public String location = "Lahore"; 
	public String jobDescription = "My issue is i need electrician to fix my fan";
	public String email = "azeemaq22@gmail.com";
	public String password = "1234@Azs";
	
	public LUHFUScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/detail_phone")
	public static WebElement phone3luhfu;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_category_name")
	public WebElement catagorynameConfirmjob;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_budget_name")
	public WebElement budgettext;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_date_name")
	public WebElement datetext;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/et_place_address")
	public static WebElement luhfu3AddressText;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_address_name")
	public WebElement confirmjobpopupaddress;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_phone_name")
	public WebElement phoneconfirmjob;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electrician']")
	public WebElement electricianCategory;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
	public WebElement continueBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Please write description here']")
	public WebElement descriptionField;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/profile_image")
	public WebElement loggedInProfileIcon;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/rel_left_half")
	public WebElement luhfuBtn;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_retry")
	public WebElement closebtn;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/linear_to_map")
	public WebElement adjustfrommap;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_reset")
	public WebElement Resetbtn;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_continue")
	public WebElement Reset;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/imageViewShowCaseClose")
	public WebElement showcaseclose;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/rel_remove_text")
	public WebElement removetextfromsearch;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_display")
	public WebElement tabsearchbar;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/et_search")
	public WebElement searchlocation;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/place_area")
	public WebElement searchsuggestion;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/bt_confirm")
	public WebElement confirmbtn;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/et_price")
	public WebElement amount;
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/continue_submit")
	public WebElement submit; 
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_continue")
	public WebElement yes;
	//com.el33tech.serviceproviders:id/tv_desc_name
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_desc_name")
	public WebElement verifydescription;


}
