package pageobjectmodel.scenario;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InputPageLogicTest extends AbstractTest {

    @Test
    public void testInputPageTextFound() {
        String sendKeys = "Hallo Welt";
        homePage.goToInputPage();
        inputPage.inputText(sendKeys);
        Assert.assertEquals(inputPage.getTextField().getText(), sendKeys, String.format("Result should be '%s'", sendKeys));
    }
}
