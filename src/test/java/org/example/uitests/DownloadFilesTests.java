package org.example.uitests;

import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class DownloadFilesTests extends BaseTestClassUseProperties {


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

        driver.findElement(By.id("textbox")).sendKeys(fileContent.toString());
        driver.findElement(By.id("create")).click();
        driver.findElement(By.linkText("Download")).click();

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




