package pageobjectmodel.scenario;

import com.microsoft.appcenter.appium.Factory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import static org.junit.Assert.assertEquals;

public class InputPageLogicTest extends AbstractTest {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Test
    public void testInputPageTextFound(){
        String sendKeys = "Hallo Welt";
        homePage.goToInputPage();
        inputPage.inputText(sendKeys);
        assertEquals(String.format("Result should be '%s'", sendKeys), sendKeys, inputPage.getTextField().getText());
    }
}
