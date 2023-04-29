package pageobjectmodel.scenario;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends AbstractTest {
    @Test
    public void testInputPageTextFound() {
        homePage.goToInputPage();
        Assert.assertEquals(inputPage.getTextView().getText(), "Bar", "Result should contain 'Bar'");
    }
}
