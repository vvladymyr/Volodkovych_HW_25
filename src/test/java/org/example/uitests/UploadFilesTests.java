package org.example.uitests;

import org.example.uitests.pages.main.MainPage;
import org.example.uitests.pages.upload.UploadPage;
import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadFilesTests extends BaseTestClass {
    @Test
    public void uploadTest() throws IOException {
        File file = MyFilesUtils.generateLoremFile();

           goToPart("upload");

       UploadPage uploadPage = new UploadPage()
               .upload(file.getAbsolutePath());

        String uploadedFileName = uploadPage.getFileUploaderText();
        Assert.assertEquals(uploadedFileName, file.getName());

        goToPart("download");

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isFileLinkDisplayed(file.getName()));

    }


}
