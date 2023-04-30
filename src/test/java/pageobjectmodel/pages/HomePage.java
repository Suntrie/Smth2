package pageobjectmodel.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjectmodel.scenario.AbstractTest;

import java.time.Duration;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AbstractTest.driver, Duration.ofSeconds(5000)),  this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,' Android-T!')]")
    private WebElement textView;

    // Класс объекта можно вытащить, например, посмотрев верстку в дебаге через driver.getPageSource()
    @AndroidFindBy(className = "android.widget.Button")
    private WebElement button;

    public void goToInputPage(){
        button.click();
    }
}
