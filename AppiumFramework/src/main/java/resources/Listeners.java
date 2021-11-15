package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import AndroidAppA.AppiumFramework.Base;

public class Listeners implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String testName = result.getName();
		try {
			Base.getScreenShot(testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
