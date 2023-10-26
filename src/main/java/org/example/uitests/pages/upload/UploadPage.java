package org.example.uitests.pages.upload;

import org.example.uitests.pages.BasePage;
import org.example.uitests.pages.download.DownloadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage extends BasePage {
    @FindBy(id = "file-upload")
    private WebElement selectFile;

    @FindBy(id = "file-submit")
    private WebElement submitFileButton;

    @FindBy(id = "uploaded-files")
    private WebElement fileUploader;


    public UploadPage() {
        super();
    }
    private UploadPage setFile (String dataFile) {
        enterFileToWebElement(selectFile, dataFile);
        return this;
    }
    private UploadPage enterFileToWebElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        return this;
    }

    private void clickSubmitFileButton() {
        submitFileButton.click();
    }

    public UploadPage upload(String dataFile) {
       setFile(dataFile)
               .clickSubmitFileButton();

        return new UploadPage();

    }
    public String getFileUploaderText() {
        return fileUploader.getText();
    }

}