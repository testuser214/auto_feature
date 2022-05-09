
import com.codeborne.selenide.BasicAuthCredentials;
import com.training.feature.pages.BasicAuthPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.AuthenticationType.BASIC;
import static com.codeborne.selenide.Selenide.*;
import static com.training.feature.pages.BasicAuthPage.SUCCESS_MESSAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Slf4j

public class BasicAuthenticationTest extends BaseTest {

    @Test
    public void executeBasicAuthenticationTest(){

        // First way is to pass username and password in the URL
        // ("http://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Second way is to use selenide open method with parameters
        BasicAuthCredentials cred = new BasicAuthCredentials("admin","admin");
        log.info("Credentials are set");

        open("http://the-internet.herokuapp.com/basic_auth", BASIC, cred);
        BasicAuthPage basicAuth = new BasicAuthPage();

        log.info("Start waiting for success message after Basic Authentication");
        basicAuth.waitForCongratulationsMessage();
        assertThat("There is no Congratulations Message", $(SUCCESS_MESSAGE).getText(), equalToIgnoringCase("Congratulations! You must have the proper credentials."));
    }
}
