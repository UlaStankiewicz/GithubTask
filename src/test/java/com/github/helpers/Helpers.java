package com.github.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;

public class Helpers {

    private WebDriver driver;

    public Helpers (WebDriver driver) {
        this.driver=driver;
    }

    public void waitForElementToBeDisplayed (WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void takeScreenshot (WebDriver driver)  {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinantionFile = new File("src//test//resource//screenshots//failedTest" + LocalTime.now().getNano()+".png");
        try {
            Files.copy(screenshotFile.toPath(),destinantionFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
