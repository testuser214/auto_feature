import com.training.feature.pages.DownloadPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.training.feature.pages.MainPage.openDownloadTask;
import static com.training.feature.pages.MainPage.openMainPage;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class DownloadTest extends BaseTest {

    @BeforeEach
    public void openTask() {
        openMainPage();
        log.info("Main Page is opened");
        openDownloadTask();
        log.info("Download Task is opened");
    }

    @Test
    public void downloadTxtFile() throws IOException {

        DownloadPage ob = new DownloadPage();
        File downloadedTxtFile = ob.downloadDummyTxt();
        String filePath = downloadedTxtFile.getPath();
        log.info("Path to File is " + filePath);
        String text = readFileToString(downloadedTxtFile, "UTF-8");
        log.info("Content of txt file: " + text);
        assertThat("Unexpected File name", downloadedTxtFile.getName().matches("test.txt"));
        assertThat("File content is wrong", text, containsString("Nightwatch"));
        assertThat("File path is empty", filePath, is(notNullValue()));
    }


    @Test

    public void downloadPdfFile() throws IOException {
        DownloadPage ob = new DownloadPage();
        File downloadedPdfFile = ob.downloadSamplePDF();
        String filePath = downloadedPdfFile.getPath();
        log.info("Path to File is " + filePath);

        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text;
        try (PDDocument document = PDDocument.load(downloadedPdfFile)) {
            text = pdfStripper.getText(document);
        }
        log.info("Content of pdf file: " + text);

        assertThat("Unexpected File name", downloadedPdfFile.getName().matches("sample.pdf"));
        assertThat("File content is wrong", text, containsString("Congratulations"));
        assertThat("File path is empty", filePath, is(notNullValue()));
    }
}