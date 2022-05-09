import com.training.feature.pages.AddingRemovingElementsPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.training.feature.pages.MainPage.openAddingRemovingElementsTask;
import static com.training.feature.pages.MainPage.openMainPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j

public class AddingRemovingTest extends BaseTest{

    int expectedNumberOfElements = 5;

    @Test
   public void executeAddingRemovingElementsTest(){
        openMainPage();
        openAddingRemovingElementsTask();
        log.info("Adding/Removing Elements Page is shown for User");
        AddingRemovingElementsPage ob = new AddingRemovingElementsPage();
        ob.addElements(expectedNumberOfElements);
        log.info("Elements are added");
        int actualNumberOfElements = ob.countNumberOfAddedElements();
        log.info("Elements are counted");
        assertThat("Expected number of elements don't match with actual number of elements", actualNumberOfElements, equalTo(expectedNumberOfElements) );
        ob.deleteElements();
        log.info("Elements are deleted");
    }

}
