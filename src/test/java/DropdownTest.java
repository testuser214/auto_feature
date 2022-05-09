import com.training.feature.pages.DropdownPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.training.feature.pages.MainPage.openDropdownTask;
import static com.training.feature.pages.MainPage.openMainPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j

public class DropdownTest extends BaseTest {

    @Test
    public void executeDropdownTest() {
        DropdownPage object = new DropdownPage();
        openMainPage();
        log.info("Main Page is opened");
        openDropdownTask();
        log.info("Dropdown Page is opened");
        object.selectOption("2");
        log.info("Option 2 is selected by value");
        assertThat("Wrong option by Value is selected", object.isOptionByValueSelected("2"), is(true));
        object.selectOptionByIndex(1);
        log.info("Option 1 is selected by index");
        assertThat("Wrong option by Name is selected", object.isOptionByIndexSelected(1), is(true));

    }
}
