package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SavedPlacesScreen {
	public String homeAddress = "iqbal town";
	public String workAddress = "awan town";
	public String customAddress = "sabzazar";
	public String customAddressName = "testHome1";
	
	public SavedPlacesScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	public WebElement homeBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Adjust From Map']")
	public WebElement adjustMapBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search places']")
	public WebElement locationSearchField;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/et_search")
	public WebElement editlocationSearchField;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
	public WebElement locationSelection;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
	public WebElement confirmBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='UPDATE HOME']")
	public WebElement updateHomeBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement updateHomeToastMessage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Work']")
	public WebElement workBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='UPDATE WORK']")
	public WebElement updateWorkBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement updateWorkToastMessage;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/iv_add_new")
	public WebElement addNewAddressIcon;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/et_place_name")
	public WebElement addCustomAddressName;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ADD PLACE']")
	public WebElement addPlaceBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement addCustomAddressToastMessage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text ='testHome1']")
	public WebElement addedCustomAddressName;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/iv_back")
	public WebElement backBtn;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/textViewOptions")
	public WebElement verticalDots;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove']")
	public WebElement removeBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes']")
	public WebElement yesBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Toast[2]")
	public WebElement locationDeletedToastMessage;
	
	

	

}
