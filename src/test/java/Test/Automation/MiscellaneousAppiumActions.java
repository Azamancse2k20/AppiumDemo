package Test.Automation;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BasicTest {
	
	@Test
	public void Misceallaneous() throws MalformedURLException, InterruptedException {
		
		// App package and app activity
		//adb shell dumpsys window | find "mCurrentFocus" -> windows
		//adb shell dumpsys window | grep -E 'mCurrentFocus' -> MAC
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
	
		// Actual Automation
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation LandScape = new DeviceRotation(0, 0, 90);
		driver.rotate(LandScape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
		String assertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(assertTitle,"WiFi settings");
		// copy to clipboard -> paste it clipboard
		driver.setClipboardText("POCO WIFI");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
			
	}

}
