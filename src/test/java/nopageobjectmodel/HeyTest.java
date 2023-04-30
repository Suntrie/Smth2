package nopageobjectmodel;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class HeyTest {
    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // iPhone Simulator, iPad Simulator, iPhone Retina 4-inch, Android Emulator, Galaxy S4 и т.д.
        // На iOS, это должно быть одно  из допустимых устройств. На Android эта возможность в настоящее время игнорируется,
        // но параметр является обязательным
        capabilities.setCapability("deviceName", "pixel");
        // Имя ОС на мобильном устройстве
        capabilities.setCapability("platformName", "Android");
        // Версия ОС
        capabilities.setCapability("platformVersion", "11.0");
        // Уникальный индефикатор подключенного устройства
        capabilities.setCapability("udid", "emulator-5554");
        // Java-пакет Android приложения, которое мы хотим запустить. (APK info)
        capabilities.setCapability("appPackage", "com.example.tester");
        // Имя activity которые мы хотим запустить из пакета, указанного выше. (APK info)
        capabilities.setCapability("appActivity", "com.example.tester.MainActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }


    @Test
    public void testTextFound() {

        //WebElement e = (WebElement) driver.findElement(By.xpath("//*[@text='Hello Android-T!']"));
        WebElement e1 = driver.findElement(By.xpath("//*[contains(@text,' Android-T!')]"));
        WebElement e2 = driver.findElement (AppiumBy.androidUIAutomator ("new UiSelector().textContains(\" Android-T!\")"));

        assertEquals("Hello Android-T!", e2.getText(), "Result should be 'Hello Android-T!'");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
