package Test.Automation;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasic extends BasicTest {
	
	@Test
	public void WifiSettingsName() throws MalformedURLException {
	
		// Actual Automation
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.className("android.widget.RelativeLayout")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
		String assertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(assertTitle,"WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("POCO WIFI");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
			
	}

}
