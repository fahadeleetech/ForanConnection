****Foran Connection Mobile AppA Automation Configurations:****

**Download and Installation:**

Download Java JDK 1.8.0.301 from Java Website. Install and set Environment Variable into Advanced System Settings → Environment Variables → Make New Java_home in System Variables and set this Path (C:\Program Files\Java\jdk1.8.0_301).

Download Eclipse Version into your system to automate the Test Scripts.

Download Node.js. Install into system and set Environment Variable into Advanced System Settings → Environment Variables → in System Variables and set this Path (C:\Program Files\nodejs) and (C:\Program Files\nodejs\node_modules\npm\bin).

Download Appium Server 1.21.0 from Appium website.

Download Android Studio and install AVD Mobile Emulator with pie version 9 and also set SDK path into Environment Variable into Advanced System Settings → Environment Variables → in System Variables and set this Path (C:\Users\Waheed Nawaz\AppData\Local\Android\Sdk\tools\bin), (C:\Users\Waheed Nawaz\AppData\Local\Android\Sdk\tools), (C:\Users\Waheed Nawaz\AppData\Local\Android\Sdk\platform-tools)

Install Selenium .jar Libraries and java client from node.js and configure into eclipse.

Now let’s begin the Testing.

Start the Appium Server 1.21.0.

Start your AVD Emulator.

Start your Eclipse version and Make a new project with Base/Home Class. 


**Base Class:**

import java.io.File;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.remote.DesiredCapabilities;




import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;




public class base {




public static AndroidDriver<AndroidElement> capabilites() throws MalformedURLException {

 

File f = new File("src");

File fs = new File(f,"test-v1.1.14-1.apk");

 

DesiredCapabilities cap = new DesiredCapabilities();

cap.setCapability("appium-version", "v1.21.0");

cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "6000");

cap.setCapability(MobileCapabilityType.DEVICE_NAME, "WaheedMU");

cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

 

AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

 

System.out.println("Application Started...");

 

return driver;

}




}




**Login Page Code of Let Us Hire for You.**

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;




import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;




public class Basics extends base {




public static void main(String[] args) throws MalformedURLException {

// TODO Auto-generated method stub




AndroidDriver<AndroidElement> driver = capabilites();

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.findElementById("com.el33tech.serviceproviders:id/tv_skip").click();

driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();

driver.findElementById("com.el33tech.serviceproviders:id/imageViewShowCaseClose").click();

driver.findElementById("com.el33tech.serviceproviders:id/profile_image").click();

driver.findElementById("com.el33tech.serviceproviders:id/tv_continue").click();

driver.findElementById("com.el33tech.serviceproviders:id/et_email").click();

driver.findElementById("com.el33tech.serviceproviders:id/et_email").sendKeys("foranseyphelay@yahoo.com");

driver.findElementById("com.el33tech.serviceproviders:id/et_pass").sendKeys("Bank@1234");

driver.findElementById("com.el33tech.serviceproviders:id/bt_submit").click();

 

//driver.findElementByXPath("//android.widget.TextView[@text='Skip']").click();

 

}




}
