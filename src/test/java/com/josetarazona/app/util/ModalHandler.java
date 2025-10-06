package com.josetarazona.app.util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalHandler {

    private final AppiumDriver driver;
    private final WebDriverWait wait;


    private final By androidAllowButtonBy = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private final By appSkipForNowButtonBy = By.xpath("//android.widget.TextView[@text='Skip for now']");

    public ModalHandler(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void acceptAndroidNotificationPermissionIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(androidAllowButtonBy)).click();
        } catch (WebDriverException ignored) {
        }
    }

    public void dismissAppPopupIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(appSkipForNowButtonBy)).click();
        } catch (WebDriverException ignored) {
        }
    }
}
