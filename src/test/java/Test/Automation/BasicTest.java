package Test.Automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// Code to start Server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\USER\\.appium\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
//			service.start();
				//AndroidDriver . IOSDriver
				// Appium code ->Appium Server -> Mobile
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Ahad_phone");
				options.setApp("D:\\Projects\\Eclipes\\AppiumDemo\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
	public void longPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
						"duration",2000));
	}
	public void scrollToEndAction() {
		
		boolean canScrollMore;
		do {
		    canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	@AfterClass
	public void teardown() {
//		driver.quit();
//		service.stop();
	}

}
