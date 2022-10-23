package AhadDemo.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class appiumBasic {
	
	@Test
	public void AppiumTest() throws MalformedURLException {
		
		//Appium code -> Appium Sever -> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Ahad_Phone");
		options.setApp("D:\\Projects\\java-2022-06\\appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		
		AndroidDriver driver = new AndroidDriver( new URL("http://127.0.0.1:4723"), options);
		driver.quit();
		
	}

}
