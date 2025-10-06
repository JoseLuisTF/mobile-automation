package com.josetarazona.app.base;

import com.josetarazona.app.config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    protected AppiumDriver driver;

    @Parameters("platformName")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String platformName) throws Exception {
        driver = DriverFactory.initializeDriver(platformName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
