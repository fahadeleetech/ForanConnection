package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Reveiw {
//com.el33tech.serviceproviders:id/iv_review
	public Reveiw(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/headerIndicator")
	public WebElement categorytitle;
	
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/headerIndicator1")
	public WebElement completiondate;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/headerIndicator2")
	public WebElement costofproject;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/headerIndicator3")
	public WebElement addcomment;
	
	@AndroidFindBy(id= "com.android.packageinstaller:id/permission_allow_button")
	public WebElement allowbtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='18']")
	public WebElement dateselect;
	//id="com.el33tech.serviceproviders:id/rel_again_yes
	//id="com.el33tech.serviceproviders:id/rel_again_no
	//com.el33tech.serviceproviders:id/image
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AC Mechanic']")
	public WebElement catagoryACMechanic;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/et_price")
	public WebElement price;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/et_description")
	public WebElement comment;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/check_view")
	public WebElement insidecamera;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/button_apply")
	public WebElement applyimage;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/ratingBar")
	public WebElement ratingbar;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/bt_add_review")
	public WebElement submitbtn;
	@AndroidFindBy(xpath= "//android.widget.TextView[@text='Add Photos']")
	public WebElement photoname;
	@AndroidFindBy(xpath= "/android.widget.ScrollView[@index='2']")
	public WebElement scrollview;
	
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/image")
	public WebElement photoicon;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/tv_segment_review")
	public WebElement reviewbtn;
	//com.el33tech.serviceproviders:id/tv_rating
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/tv_continue")
	public WebElement yes;
	@AndroidFindBy(id= "com.el33tech.serviceproviders:id/tv_rating")
	public WebElement textReview;
	
	}
