package Test.Automation;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class LongPress extends BasicTest {
	
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException {
	
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		//longPressAction by parent class
		longPressAction(element);
		Thread.sleep(2000);
		
		String manuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(manuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

		
	}

}
