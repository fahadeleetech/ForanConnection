package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchScreen {
	public String serviceProvider = "Madina traders";
	
	public SearchScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Around me']")
	public WebElement aroundMeIcon;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/et_search")
	public WebElement searchField;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
	public WebElement firstSearchSuggestion;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/name")
	public List<WebElement> displayedCategories;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/recyclerView")
	public List<WebElement> displayedVendors;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/et_search")
	public WebElement searchedText;
	
	@AndroidFindBy(id = "com.el33tech.serviceproviders:id/tv_sp_name")
	public WebElement firstSearchedCard;
	

}
