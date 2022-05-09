import com.training.feature.pages.CheckboxesPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.training.feature.pages.MainPage.openCheckboxesTask;
import static com.training.feature.pages.MainPage.openMainPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j

public class CheckboxesTest extends BaseTest {

    @Test
    public void executeCheckboxesTest() throws InterruptedException {
        openMainPage();
        log.info("Main Page is opened");
        openCheckboxesTask();
        log.info("Checkbox Page is shown for User");
        CheckboxesPage checkbox = new CheckboxesPage();
        checkbox.makeAllCheckboxesSelected();
        log.info("All Checkboxes are marked as selected");
        boolean areCheckboxesStateChecked = checkbox.validateCheckboxesState();
        assertThat("Validation of Checkboxes state was successful", areCheckboxesStateChecked, is(true));

    }
}
