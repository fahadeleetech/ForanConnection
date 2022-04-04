package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BrowseAllPO {
	
	public BrowseAllPO(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tvBrowseAll")
	public WebElement BrowseAllButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electrician']")
	public WebElement Electrician;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Heating & Cooling']")
	public WebElement HeatingandCooling;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electronics & Repair']")
	public WebElement ElectronicsandRepair;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Plumber']")
	public WebElement Plumber;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hardware']")
	public WebElement Hardware;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electronics Repair']")
	public WebElement ElectronicsRepair;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sanitary']")
	public WebElement Sanitary;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Handyman']")
	public WebElement Handyman;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Painter']")
	public WebElement Painter;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Carpenter']")
	public WebElement Carpenter;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AC Mechanic']")
	public WebElement ACMechanic;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Glass Works']")
	public WebElement GlassWorks;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Boring']")
	public WebElement Boring;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Door Works']")
	public WebElement DoorWorks;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Glass Designer']")
	public WebElement GlassDesigner;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lock Master']")
	public WebElement LockMaster;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Electrical Supplies']")
	public WebElement ElectricalSupplies;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Furniture']")
	public WebElement Furniture;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cook']")
	public WebElement Cook;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Moving']")
	public WebElement Moving;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gardener']")
	public WebElement Gardener;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Maid']")
	public WebElement Maid;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Around me']")
	public WebElement AroundMe;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	public WebElement HomeAddress;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/imageViewShowCaseClose")
	public WebElement ShowCaseButton;
	
	
	
	
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/iv_back")
	public WebElement BackButton;
	

}
