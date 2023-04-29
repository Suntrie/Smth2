package pageobjectmodel.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjectmodel.scenario.AbstractTest;

@Data
public class InputPage {

    public InputPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AbstractTest.driver), this);
    }

    //https://www.browserstack.com/guide/locators-in-appium
    //Xpath in Appium analyzes the XML structure of the app and then locates the element. Xpath should only be used when there is no ID, Name, or accessibility ID assigned to a specific UI element. Although XPath allows for the formulation of complex queries, using XPath is not recommended because it has stability and performance issues (as mentioned in the official documentation).
    @AndroidFindBy(xpath = "//*[contains(@text,'Bar')]")
    private WebElement textView;

    @AndroidFindBy(className = "androidx.compose.material3.TextField")
    private WebElement textField;

    public void inputText(String input){
       textField.sendKeys(input);
    }
}
