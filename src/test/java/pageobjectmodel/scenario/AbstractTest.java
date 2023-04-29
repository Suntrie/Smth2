package pageobjectmodel.scenario;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjectmodel.pages.HomePage;
import pageobjectmodel.pages.InputPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AbstractTest {

    public static AppiumDriver driver;

    HomePage homePage;
    InputPage inputPage;

    @BeforeClass
    public void setUp() {
        try {
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
            capabilities.setCapability("app", new File("src/test/resources/app-debug.apk").getAbsolutePath());
            capabilities.setCapability("appActivity", "com.example.tester.MainActivity");
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
            homePage = new HomePage();
            inputPage = new InputPage();
        } catch (MalformedURLException e) {
            System.out.println("Please check URL. \n Error:" + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
