package org.example.uitests;

import org.example.uitests.pages.download.DownloadPage;
import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DownloadFilesTests extends BaseTestClass {


    @Test
    public void downloadTest() throws IOException, InterruptedException {
        File file = MyFilesUtils.generateLoremFile();

           goToUrl();

        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        }

        DownloadPage downloadPage = new DownloadPage()
        .download(fileContent.toString());

        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("C:\\Users\\пк\\Downloads\\easyinfo.txt"));

        StringBuilder downloadedFileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = reader.readLine()) != null) {
                downloadedFileContent.append(line).append("\n");
            }
        }

        String fileContentStr = fileContent.toString().replaceAll("\r\n", "\n");
        String downloadedContent = downloadedFileContent.toString().replaceAll("\r\n", "\n");

        Assert.assertEquals(fileContentStr, downloadedContent);

        file1.deleteOnExit();
        file.deleteOnExit();
    }
}




