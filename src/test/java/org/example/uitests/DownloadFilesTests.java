package org.example.uitests;

import org.example.uitests.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
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

        String fileContent = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        driver.findElement(By.id("textbox")).sendKeys(fileContent);
        driver.findElement(By.id("create")).click();
        driver.findElement(By.linkText("Download")).click();

        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("C:\\Users\\пк\\Downloads\\easyinfo.txt"));

        String downloadedFileContent = new String(Files.readAllBytes(file1.toPath()), StandardCharsets.UTF_8);
        fileContent = fileContent.replaceAll("\r\n", "\n");
        downloadedFileContent = downloadedFileContent.replaceAll("\r\n", "\n");

        Assert.assertEquals(fileContent, downloadedFileContent);



    }


    }


