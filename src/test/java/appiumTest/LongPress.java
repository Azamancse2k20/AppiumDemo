package appiumTest;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
		
	@Test
	public void WifiSettingsName() throws MalformedURLException, InterruptedException {
			// Actual Automation
			// X-path, id, accessibilityId, className, androidUIAutomator
		     
		//tagName[@attribute='value] ->//tagName
	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		LongpressAction(element);
		
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),
//				"duration",2000));
		String manuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(manuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	
		
		
//		Thread.sleep(2000);
		
	}
	
}
