package com.github.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class DriverFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver (String driverType) throws NoSuchDriverException {

        if (driverInstance == null) {

            getSpecyficDriver(driverType);
            driverInstance.manage().window().maximize();

        } return driverInstance;
    }

    private static void getSpecyficDriver(String driverType) throws NoSuchDriverException {

        switch (driverType) {

            case "CHROME_WINDOWS":
                File chromeDriver_windows = new File("src/test/resource/drivers/chromedriver_windows.exe");
                ChromeDriverService chromeService_windows = new ChromeDriverService.Builder().usingDriverExecutable(chromeDriver_windows).build();
                driverInstance = (new ChromeDriver(chromeService_windows));
                break;

            case "CHROME_IOS":
                File chromeDriver_ios = new File("src/test/resource/drivers/chromedriver_ios");
                ChromeDriverService chromeService_ios = new ChromeDriverService.Builder().usingDriverExecutable(chromeDriver_ios).build();
                driverInstance = (new ChromeDriver(chromeService_ios));
                break;

            //Space for next driver implementations ex. EDGEdriver

            default:
                System.out.println("Driver type has a bad value or driver does not have an implementation");
                throw new NoSuchDriverException();

        }

    }

    public static void resetDriver () {

        driverInstance = null;
    }
}
