import com.training.feature.pages.ContextMenuPage;
import org.junit.jupiter.api.Test;

import static com.training.feature.pages.MainPage.openContextMenuTask;
import static com.training.feature.pages.MainPage.openMainPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ContextMenuTest {

    @Test
    public void executeContextMenuTest() {
        openMainPage();
        openContextMenuTask();
        ContextMenuPage ob = new ContextMenuPage();
        ob.contextClickOnHotSpot();
        String alertMessage = ob.getAlertText();
        assertThat("Alert text message doesn't match expected value", alertMessage, equalToIgnoringCase("You selected a context menu"));
        ob.confirmNotification();
    }
}
