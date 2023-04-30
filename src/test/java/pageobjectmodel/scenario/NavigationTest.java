package pageobjectmodel.scenario;

import com.microsoft.appcenter.appium.Factory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import static org.junit.Assert.assertEquals;

public class NavigationTest extends AbstractTest {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    @Test
    public void testInputPageTextFound() {
        homePage.goToInputPage();
        assertEquals( "Result should contain 'Bar'", "Bar", inputPage.getTextView().getText());
    }
}
