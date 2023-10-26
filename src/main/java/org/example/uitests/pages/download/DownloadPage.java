package org.example.uitests.pages.download;

import org.example.uitests.pages.BasePage;
import org.example.uitests.pages.upload.UploadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadPage extends BasePage {
    @FindBy(id = "textbox")
    private WebElement enterDataField;

    @FindBy(id = "create")
    private WebElement createFileButton;

    @FindBy(linkText = "Download")
    private WebElement downloadFileButton;

    public DownloadPage(){
        super();
    }
//    private DownloadPage setDataField (String dataField){
//        enterDataField.clear();
//        enterDataField.sendKeys(dataField);
//        return this;
        private DownloadPage setDataField (String dataField){
       enterValueToWebElement(enterDataField, dataField);
       return this;
}

    private DownloadPage enterValueToWebElement(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
        return this;
    }
    private void clickCreateFileButton(){
        createFileButton.click();
    }
    private void clickDownloadFileButton(){
        downloadFileButton.click();
    }
    public DownloadPage download(String dataField){
          setDataField(dataField)
                  .clickCreateFileButton();
        clickDownloadFileButton();
        return new DownloadPage();


    }
}
