import com.training.feature.pages.FormAuthenticationPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.training.feature.pages.MainPage.openLoginTask;
import static com.training.feature.pages.MainPage.openMainPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j

public class FormAuthenticationTest extends BaseTest{
    String username = "tomsmith";
    String password = "SuperSecretPassword!";

    @Test
    public void executeLoginTest(){
        openMainPage();
        log.info("Main Page is opened");
        openLoginTask();
        log.info("Login Page is opened");
        FormAuthenticationPage object = new FormAuthenticationPage();
        object.setUsername(username);
        log.info("Username is set");
        object.setPassword(password);
        log.info("Pwd is set");
        object.clickOnLoginButton();

        boolean isMessageShown = object.isResultMessageShown();
        assertThat("Result Message isn't shown", isMessageShown, is(true) );

        String message = object.getTextFromResultMessage();
        assertThat("Unexpected text message", message, containsString("You logged into a secure area!"));

    }
}
